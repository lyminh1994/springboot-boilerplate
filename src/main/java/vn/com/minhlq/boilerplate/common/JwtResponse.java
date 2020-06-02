package vn.com.minhlq.boilerplate.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;

    private String tokenType = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }
}
