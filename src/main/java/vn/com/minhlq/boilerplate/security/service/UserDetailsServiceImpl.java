package vn.com.minhlq.boilerplate.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.minhlq.boilerplate.model.Permission;
import vn.com.minhlq.boilerplate.model.Role;
import vn.com.minhlq.boilerplate.model.User;
import vn.com.minhlq.boilerplate.repository.PermissionRepository;
import vn.com.minhlq.boilerplate.repository.RoleRepository;
import vn.com.minhlq.boilerplate.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Custom UserDetails Service
 * </p>
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User information not found : " + username));
        List<Role> roles = roleRepository.selectByUserId(user.getId());
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        List<Permission> permissions = permissionRepository.selectByRoleIdList(roleIds);
        return UserPrinciple.create(user, roles, permissions);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
