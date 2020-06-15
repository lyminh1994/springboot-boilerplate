package vn.com.minhlq.boilerplate.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.com.minhlq.boilerplate.constant.CommonConst;
import vn.com.minhlq.boilerplate.model.Permission;
import vn.com.minhlq.boilerplate.model.Role;
import vn.com.minhlq.boilerplate.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * Customize User
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrinciple implements UserDetails {
    /**
     * Primary key
     */
    private Long id;

    /**
     * Username
     */
    private String username;

    /**
     * Password
     */
    @JsonIgnore
    private String password;

    /**
     * Nick name
     */
    private String nickname;

    /**
     * Phone numbers
     */
    private String phone;

    /**
     * Email
     */
    private String email;

    /**
     * Birthday
     */
    private Long birthday;

    /**
     * Gender, male-1, female-2
     */
    private Integer sex;

    /**
     * Status, enable-1, disable-0
     */
    private Integer status;

    /**
     * Create time
     */
    private Long createTime;

    /**
     * Update time
     */
    private Long updateTime;

    /**
     * List roles of user
     */
    private List<String> roles;

    /**
     * List user permissions
     */
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrinciple create(User user, List<Role> roles, List<Permission> permissions) {
        List<String> roleNames = roles.stream().map(Role::getName).collect(Collectors.toList());

        List<GrantedAuthority> authorities = permissions.stream()
                .filter(permission -> StringUtils.isNotBlank(permission.getPermission()))
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());

        return new UserPrinciple(user.getId(), user.getUsername(), user.getPassword(), user.getNickname(), user.getPhone(), user.getEmail(), user.getBirthday(), user.getSex(), user.getStatus(), user.getCreateTime(), user.getUpdateTime(), roleNames, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(this.status, CommonConst.ENABLE);
    }
}
