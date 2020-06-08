package vn.com.minhlq.boilerplate.security.jwt;

import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import vn.com.minhlq.boilerplate.constant.CommonConst;
import vn.com.minhlq.boilerplate.constant.Status;
import vn.com.minhlq.boilerplate.security.service.UserPrinciple;
import vn.com.minhlq.boilerplate.exception.SecurityException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * JWT Tools
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.util
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(JwtConfig.class)
public class JwtProvider {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * Create JWT
     *
     * @param rememberMe  Remember me
     * @param id          User id
     * @param subject     Username
     * @param roles       List roles of user
     * @param authorities User authorities
     * @return JWT
     */
    public String createJWT(Boolean rememberMe, Long id, String subject, List<String> roles, Collection<? extends GrantedAuthority> authorities) {
        Date now = new Date();
        JwtBuilder builder = Jwts.builder()
                .setId(id.toString())
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getKey())
                .claim("roles", roles)
                .claim("authorities", authorities);

        // Set expiration time
        Long ttl = rememberMe ? jwtConfig.getRemember() : jwtConfig.getTtl();
        if (ttl > 0) {
            builder.setExpiration(DateUtil.offsetMillisecond(now, ttl.intValue()));
        }

        String jwt = builder.compact();
        // Save the generated JWT to Redis
        stringRedisTemplate.opsForValue().set(CommonConst.REDIS_JWT_KEY_PREFIX + subject, jwt, ttl, TimeUnit.MILLISECONDS);
        return jwt;
    }

    /**
     * Create JWT
     *
     * @param authentication User authentication information
     * @param rememberMe     Remember me
     * @return JWT
     */
    public String createJWT(Authentication authentication, Boolean rememberMe) {
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        return createJWT(rememberMe, userPrincipal.getId(), userPrincipal.getUsername(), userPrincipal.getRoles(), userPrincipal.getAuthorities());
    }

    /**
     * Parsing JWT
     *
     * @param jwt JWT token
     * @return {@link Claims}
     */
    public Claims parseJWT(String jwt) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getKey())
                    .parseClaimsJws(jwt)
                    .getBody();

            String username = claims.getSubject();
            String redisKey = CommonConst.REDIS_JWT_KEY_PREFIX + username;

            // Verify the existence of JWT in Redis
            Long expire = stringRedisTemplate.getExpire(redisKey, TimeUnit.MILLISECONDS);
            if (Objects.isNull(expire) || expire <= 0) {
                throw new SecurityException(Status.TOKEN_EXPIRED);
            }

            // Verify that the JWT in Redis is consistent with the current one.
            // If it is inconsistent, it means that the user has logged out/the user is logged in on a different device, which means that the JWT has expired
            String redisToken = stringRedisTemplate.opsForValue().get(redisKey);
            if (!StringUtils.equals(jwt, redisToken)) {
                throw new SecurityException(Status.TOKEN_OUT_OF_CTRL);
            }
            return claims;
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token");
            throw new SecurityException(Status.TOKEN_EXPIRED);
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token");
            throw new SecurityException(Status.TOKEN_PARSE_ERROR);
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token");
            throw new SecurityException(Status.TOKEN_PARSE_ERROR);
        } catch (SignatureException e) {
            log.error("Invalid JWT token signature");
            throw new SecurityException(Status.TOKEN_PARSE_ERROR);
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty");
            throw new SecurityException(Status.TOKEN_PARSE_ERROR);
        }
    }

    /**
     * Set JWT expiration
     *
     * @param request Request
     */
    public void invalidateJWT(HttpServletRequest request) {
        String jwt = getJwtFromRequest(request);
        String username = getUsernameFromJWT(jwt);
        // Clear JWT from Redis
        stringRedisTemplate.delete(CommonConst.REDIS_JWT_KEY_PREFIX + username);
    }

    /**
     * Get username based on jwt
     *
     * @param jwt JWT token
     * @return Username
     */
    public String getUsernameFromJWT(String jwt) {
        Claims claims = parseJWT(jwt);
        return claims.getSubject();
    }

    /**
     * Get JWT token from the request header
     *
     * @param request Request
     * @return JWT token
     */
    public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
