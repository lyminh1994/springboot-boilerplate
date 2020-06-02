package vn.com.minhlq.boilerplate.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.common.BaseException;
import vn.com.minhlq.boilerplate.common.PageResult;
import vn.com.minhlq.boilerplate.constant.Status;
import vn.com.minhlq.boilerplate.dto.OnlineUser;
import vn.com.minhlq.boilerplate.common.PageCondition;
import vn.com.minhlq.boilerplate.services.MonitorService;
import vn.com.minhlq.boilerplate.utils.PageUtil;
import vn.com.minhlq.boilerplate.utils.SecurityUtil;

import java.util.List;

/**
 * <p>
 * Monitor Controller, online users, manually kick out users and other functions
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/api/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;


    @GetMapping("/online/user")
    public ApiResponse onlineUser(PageCondition pageCondition) {
        PageUtil.checkPageCondition(pageCondition, PageCondition.class);
        PageResult<OnlineUser> pageResult = monitorService.onlineUser(pageCondition);
        return ApiResponse.ofSuccess(pageResult);
    }

    @DeleteMapping("/online/user/kick-out")
    public ApiResponse kickOutOnlineUser(@RequestBody List<String> names) {
        if (CollectionUtils.isEmpty(names)) {
            throw new BaseException(Status.PARAM_NOT_NULL);
        }
        if (names.contains(SecurityUtil.getCurrentUsername())) {
            throw new BaseException(Status.KICK_OUT_SELF);
        }
        monitorService.kickOut(names);
        return ApiResponse.ofSuccess();
    }
}
