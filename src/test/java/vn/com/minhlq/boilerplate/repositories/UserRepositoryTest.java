package vn.com.minhlq.boilerplate.repositories;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vn.com.minhlq.boilerplate.BoilerplateApplicationTests;
import vn.com.minhlq.boilerplate.model.User;

import java.util.List;

/**
 * <p>
 * UserRepository 测试
 * </p>
 *
 * @package:
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Slf4j
public class UserRepositoryTest extends BoilerplateApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameIn() {
        List<String> usernameList = Lists.newArrayList("admin", "user");
        List<User> userList = userRepository.findByUsernameIn(usernameList);
        Assert.assertEquals(2, userList.size());
        log.info("【userList】= {}", userList);
    }
}