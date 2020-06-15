package vn.com.minhlq.boilerplate.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * Login request parameters
 * </p>
 */
@Data
public class LoginRequest {

    /**
     * Username
     */
    @NotBlank(message = "UserName can not be empty")
    private String userName;

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
