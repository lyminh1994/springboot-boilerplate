package vn.com.minhlq.boilerplate.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.constant.Status;
import vn.com.minhlq.boilerplate.exception.SecurityException;
import vn.com.minhlq.boilerplate.payload.request.LoginRequest;
import vn.com.minhlq.boilerplate.security.jwt.JwtProvider;
import vn.com.minhlq.boilerplate.payload.response.JwtResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 * Authentication Controller, including user registration, user login request
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
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    /**
     * Login
     */
    @PostMapping("/login")
    public ApiResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmailOrPhone(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.createJWT(authentication, loginRequest.getRememberMe());
        return ApiResponse.ofSuccess(new JwtResponse(jwt));
    }

    /**
     * Logout
     */
    @PostMapping("/logout")
    public ApiResponse logout(HttpServletRequest request) {
        try {
            // Set JWT expiration
            jwtProvider.invalidateJWT(request);
        } catch (SecurityException e) {
            throw new SecurityException(Status.UNAUTHORIZED);
        }
        return ApiResponse.ofStatus(Status.LOGOUT);
    }
}
