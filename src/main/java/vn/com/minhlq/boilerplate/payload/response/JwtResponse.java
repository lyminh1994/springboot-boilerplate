package vn.com.minhlq.boilerplate.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * JWT Response
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    /**
     * token data
     */
    private String token;

    /**
     * token type
     */
    private String tokenType = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }
}
