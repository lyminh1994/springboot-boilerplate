package vn.com.minhlq.boilerplate.controller;

import lombok.extern.slf4j.Slf4j;
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
import vn.com.minhlq.boilerplate.payload.response.JwtResponse;
import vn.com.minhlq.boilerplate.security.jwt.JwtProvider;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 * Authentication Controller, including user registration, user login, logout request
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    public AuthController(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    /**
     * Login
     */
    @PostMapping("/login")
    public ApiResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

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
            // Set JWT expiration to logout
            jwtProvider.invalidateJWT(request);
        } catch (SecurityException e) {
            throw new SecurityException(Status.UNAUTHORIZED);
        }
        return ApiResponse.ofStatus(Status.LOGOUT);
    }
}
