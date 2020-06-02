package vn.com.minhlq.boilerplate.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vn.com.minhlq.boilerplate.common.ApiResponse;


@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ApiResponse list() {
        log.info("Test GET list");
        return ApiResponse.ofMessage("Test GET list");
    }

    @PostMapping
    public ApiResponse add() {
        log.info("Test added");
        return ApiResponse.ofMessage("Test added");
    }

    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Long id) {
        log.info("Test modification");
        return ApiResponse.ofSuccess("Test modification");
    }
}
