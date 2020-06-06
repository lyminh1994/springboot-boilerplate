package vn.com.minhlq.boilerplate.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.common.Status;
import vn.com.minhlq.boilerplate.model.Permission;
import vn.com.minhlq.boilerplate.model.Role;
import vn.com.minhlq.boilerplate.model.User;
import vn.com.minhlq.boilerplate.repositories.PermissionRepository;
import vn.com.minhlq.boilerplate.repositories.RoleRepository;
import vn.com.minhlq.boilerplate.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Test Controller
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
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @GetMapping
    public ApiResponse list() {
        log.info("Test get list");
        List<Object> result = new ArrayList<>();
        List<User> users = userRepository.findAll();
        List<Role> roles = roleRepository.findAll();
        List<Permission> permissions = permissionRepository.findAll();
        result.add(users);
        result.add(roles);
        result.add(permissions);
        return ApiResponse.ofStatus(Status.SUCCESS, result);
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
