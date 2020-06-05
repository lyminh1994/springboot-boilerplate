package vn.com.minhlq.boilerplate.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vn.com.minhlq.boilerplate.common.ApiResponse;

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

    @GetMapping
    public ApiResponse list() {
        log.info("Test get list");
        return ApiResponse.ofMessage("Test get list");
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
