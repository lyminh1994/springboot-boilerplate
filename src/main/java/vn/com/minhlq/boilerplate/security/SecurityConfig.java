package vn.com.minhlq.boilerplate.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import vn.com.minhlq.boilerplate.security.jwt.CustomConfig;
import vn.com.minhlq.boilerplate.security.jwt.JwtAuthenticationFilter;
import vn.com.minhlq.boilerplate.security.service.UserDetailsServiceImpl;

/**
 * <p>
 * Security Configuration
 * </p>
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(CustomConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomConfig customConfig;

    private final AccessDeniedHandler accessDeniedHandler;

    private final UserDetailsServiceImpl userDetailsService;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(CustomConfig customConfig, AccessDeniedHandler accessDeniedHandler, UserDetailsServiceImpl userDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.customConfig = customConfig;
        this.accessDeniedHandler = accessDeniedHandler;
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.cors()
            // Close CSRF
            .and().csrf().disable()
            // The login behavior is implemented by yourself, refer to AuthController#login
            .formLogin().disable()
            .httpBasic().disable()

            // Authentication request
            .authorizeRequests()

            // All requests require login access
            .antMatchers()
            .authenticated()

            // Role Base Access Control dynamic url authentication
            .anyRequest()
            .access("@authorityService.hasPermission(request,authentication)")

            // The logout behavior is implemented by yourself, refer to AuthController#logout
            .and().logout().disable()
            // Session management
            .sessionManagement()
            // Because JWT is used, Session is not managed here
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            // Exception handling
            .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        // @formatter:on

        // Add custom JWT filter
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Allow all requests that can be accessed without login, see AuthController
     * Can also be {@link #configure(HttpSecurity)} Configuration
     * {@code http.authorizeRequests().antMatchers("/api/auth/**").permitAll()}
     */
    @Override
    public void configure(WebSecurity web) {
        WebSecurity and = web.ignoring().and();

        // Ignore GET
        customConfig.getIgnores().getGet().forEach(url -> and.ignoring().antMatchers(HttpMethod.GET, url));

        // Ignore POST
        customConfig.getIgnores().getPost().forEach(url -> and.ignoring().antMatchers(HttpMethod.POST, url));

        // Ignore DELETE
        customConfig.getIgnores().getDelete().forEach(url -> and.ignoring().antMatchers(HttpMethod.DELETE, url));

        // Ignore PUT
        customConfig.getIgnores().getPut().forEach(url -> and.ignoring().antMatchers(HttpMethod.PUT, url));

        // Ignore HEAD
        customConfig.getIgnores().getHead().forEach(url -> and.ignoring().antMatchers(HttpMethod.HEAD, url));

        // Ignore PATCH
        customConfig.getIgnores().getPatch().forEach(url -> and.ignoring().antMatchers(HttpMethod.PATCH, url));

        // Ignore OPTIONS
        customConfig.getIgnores().getOptions().forEach(url -> and.ignoring().antMatchers(HttpMethod.OPTIONS, url));

        // Ignore TRACE
        customConfig.getIgnores().getTrace().forEach(url -> and.ignoring().antMatchers(HttpMethod.TRACE, url));

        // Ignore requested
        customConfig.getIgnores().getPattern().forEach(url -> and.ignoring().antMatchers(url));

    }
}
