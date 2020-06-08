package vn.com.minhlq.boilerplate.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * Login request parameters
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.payload
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Data
public class LoginRequest {

    /**
     * Username or email or mobile phone number
     */
    @NotBlank(message = "Username can not be empty")
    private String usernameOrEmailOrPhone;

    /**
     * Password
     */
    @NotBlank(message = "Password can not be empty")
    private String password;

    /**
     * Remember me
     */
    private Boolean rememberMe = false;

}
