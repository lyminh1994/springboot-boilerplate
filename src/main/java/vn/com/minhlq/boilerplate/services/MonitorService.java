package vn.com.minhlq.boilerplate.services;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.minhlq.boilerplate.constant.Consts;
import vn.com.minhlq.boilerplate.common.PageResult;
import vn.com.minhlq.boilerplate.dto.OnlineUser;
import vn.com.minhlq.boilerplate.model.User;
import vn.com.minhlq.boilerplate.common.PageCondition;
import vn.com.minhlq.boilerplate.repositories.UserRepository;
import vn.com.minhlq.boilerplate.utils.RedisUtil;
import vn.com.minhlq.boilerplate.utils.SecurityUtil;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class MonitorService {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserRepository userRepository;

    /**
     * Online user pagination list
     *
     * @param pageCondition Paging parameters
     * @return Online user pagination list
     */
    public PageResult<OnlineUser> onlineUser(PageCondition pageCondition) {
        PageResult<String> keys = redisUtil.findKeysForPage(Consts.REDIS_JWT_KEY_PREFIX + Consts.SYMBOL_STAR, pageCondition.getCurrentPage(), pageCondition.getPageSize());
        List<String> rows = keys.getRows();
        Long total = keys.getTotal();

        // Get a list of usernames based on the redis middle key
        List<String> usernameList = rows.stream()
                .map(s -> StrUtil.subAfter(s, Consts.REDIS_JWT_KEY_PREFIX, true))
                .collect(Collectors.toList());
        // Query user information based on Username
        List<User> userList = userRepository.findByUsernameIn(usernameList);

        // Encapsulate online user information
        List<OnlineUser> onlineUserList = Lists.newArrayList();
        userList.forEach(user -> onlineUserList.add(OnlineUser.create(user)));

        return new PageResult<>(onlineUserList, total);
    }

    /**
     * Kick out online users
     *
     * @param names User name list
     */
    public void kickOut(List<String> names) {
        // Clear JWT information in Redis
        List<String> redisKeys = names.parallelStream()
                .map(s -> Consts.REDIS_JWT_KEY_PREFIX + s)
                .collect(Collectors.toList());
        redisUtil.delete(redisKeys);

        // Get current username
        String currentUsername = SecurityUtil.getCurrentUsername();
        names.parallelStream()
                .forEach(name -> {
                    // TODO: Notify that the kicked out user has been kicked out by the currently logged in user,
                    // Later consider using websocket to achieve, the specific pseudo code implementation is as follows.
                    // String message = "You have been manually logged off by the user [" + currentUsername + "]!";
                    log.debug("User [{}] was manually offline by user [{}]!", name, currentUsername);
                });
    }
}
