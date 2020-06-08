package vn.com.minhlq.boilerplate.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * JWT Response
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.dto
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    /**
     * token field
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
