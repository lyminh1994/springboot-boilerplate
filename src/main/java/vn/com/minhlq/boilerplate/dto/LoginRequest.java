package vn.com.minhlq.boilerplate.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank(message = "Username can not be empty")
    private String usernameOrEmailOrPhone;

    @NotBlank(message = "Password can not be empty")
    private String password;

    private Boolean rememberMe = false;

}
