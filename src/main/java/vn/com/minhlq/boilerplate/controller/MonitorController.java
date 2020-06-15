package vn.com.minhlq.boilerplate.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.common.PageRequest;
import vn.com.minhlq.boilerplate.common.PageResult;
import vn.com.minhlq.boilerplate.constant.Status;
import vn.com.minhlq.boilerplate.dto.OnlineUserDto;
import vn.com.minhlq.boilerplate.exception.SecurityException;
import vn.com.minhlq.boilerplate.service.MonitorService;
import vn.com.minhlq.boilerplate.util.PageUtil;
import vn.com.minhlq.boilerplate.util.SecurityUtil;

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

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    /**
     * Online user list
     *
     * @param pageCondition Paging parameters
     */
    @GetMapping("/online/user")
    public ApiResponse onlineUser(PageRequest pageCondition) {
        PageUtil.checkPageCondition(pageCondition, PageRequest.class);
        PageResult<OnlineUserDto> pageResult = monitorService.onlineUser(pageCondition);
        return ApiResponse.ofSuccess(pageResult);
    }

    /**
     * Kick out online users in batches
     *
     * @param names List username to kick out
     */
    @DeleteMapping("/online/user/kick-out")
    public ApiResponse kickOutOnlineUser(@RequestBody List<String> names) {
        if (CollectionUtils.isEmpty(names)) {
            throw new SecurityException(Status.PARAM_NOT_NULL);
        }
        if (names.contains(SecurityUtil.getCurrentUsername())) {
            throw new SecurityException(Status.KICK_OUT_SELF);
        }
        monitorService.kickOut(names);
        return ApiResponse.ofSuccess();
    }
}
