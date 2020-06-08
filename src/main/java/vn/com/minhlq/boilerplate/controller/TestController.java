package vn.com.minhlq.boilerplate.controller.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.constant.Status;
import vn.com.minhlq.boilerplate.model.User;
import vn.com.minhlq.boilerplate.security.service.UserDetailsServiceImpl;

import java.util.List;

/**
 * <p>
 * Test Controller
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.controller.api
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public ApiResponse list() {
        log.info("Test get list");
        List<User> users = userDetailsService.getAllUser();
        return ApiResponse.ofStatus(Status.SUCCESS, users);
    }

    @GetMapping("/gen-password")
    public ApiResponse genPassword() {
        log.info("Test get list");
        return ApiResponse.ofStatus(Status.SUCCESS, passwordEncoder.encode("123456"));
    }

    @PostMapping
    public ApiResponse add() {
        log.info("Test add");
        return ApiResponse.ofMessage("Test add");
    }

    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Long id) {
        log.info("Test modification");
        return ApiResponse.ofSuccess("Test modification");
    }
}
