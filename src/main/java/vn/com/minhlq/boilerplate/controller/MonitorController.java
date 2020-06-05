package vn.com.minhlq.boilerplate.controller;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.common.PageResult;
import vn.com.minhlq.boilerplate.common.Status;
import vn.com.minhlq.boilerplate.exception.SecurityException;
import vn.com.minhlq.boilerplate.payload.PageCondition;
import vn.com.minhlq.boilerplate.services.MonitorService;
import vn.com.minhlq.boilerplate.util.PageUtil;
import vn.com.minhlq.boilerplate.util.SecurityUtil;
import vn.com.minhlq.boilerplate.vo.OnlineUser;

import java.util.List;

/**
 * <p>
 * Monitor Controller, online users, manually kick out users and other functions
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.controller
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Slf4j
@RestController
@RequestMapping("/api/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    /**
     * Online user list
     *
     * @param pageCondition Paging parameters
     */
    @GetMapping("/online/user")
    public ApiResponse onlineUser(PageCondition pageCondition) {
        PageUtil.checkPageCondition(pageCondition, PageCondition.class);
        PageResult<OnlineUser> pageResult = monitorService.onlineUser(pageCondition);
        return ApiResponse.ofSuccess(pageResult);
    }

    /**
     * Kick out online users in batches
     *
     * @param names User name list
     */
    @DeleteMapping("/online/user/kick-out")
    public ApiResponse kickOutOnlineUser(@RequestBody List<String> names) {
        if (CollUtil.isEmpty(names)) {
            throw new SecurityException(Status.PARAM_NOT_NULL);
        }
        if (names.contains(SecurityUtil.getCurrentUsername())) {
            throw new SecurityException(Status.KICKOUT_SELF);
        }
        monitorService.kickOut(names);
        return ApiResponse.ofSuccess();
    }
}
