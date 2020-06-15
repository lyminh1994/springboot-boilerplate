package vn.com.minhlq.boilerplate.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vn.com.minhlq.boilerplate.common.ApiResponse;

/**
 * <p>
 * Test Controller
 * </p>
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
        log.info("Test modification with Id: " + id);
        return ApiResponse.ofSuccess("Test modification with Id: " + id);
    }
}
