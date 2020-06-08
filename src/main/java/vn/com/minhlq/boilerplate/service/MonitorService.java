package vn.com.minhlq.boilerplate.service;

import vn.com.minhlq.boilerplate.common.PageResult;
import vn.com.minhlq.boilerplate.common.PageRequest;
import vn.com.minhlq.boilerplate.dto.OnlineUserDto;

import java.util.List;

/**
 * <p>
 * Monitor Service
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.services
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
public interface MonitorService {

    /**
     * Online user pagination list
     *
     * @param pageCondition PageRequest
     * @return Online user pagination list
     */
    PageResult<OnlineUserDto> onlineUser(PageRequest pageCondition);

    /**
     * Kick out online users
     *
     * @param names List<String>
     */
    void kickOut(List<String> names);

}
