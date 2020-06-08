package vn.com.minhlq.boilerplate.repositories;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.com.minhlq.boilerplate.BoilerplateApplicationTests;
import vn.com.minhlq.boilerplate.model.*;
import vn.com.minhlq.boilerplate.model.unionkey.RolePermissionsKey;
import vn.com.minhlq.boilerplate.model.unionkey.UserRolesKey;
import vn.com.minhlq.boilerplate.repository.*;

/**
 * <p>
 * Data initialization test
 * </p>
 *
 * @package:
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
public class DataInitTest extends BoilerplateApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private RolePermissionsRepository rolePermissionsRepository;

    @Autowired
    private Snowflake snowflake;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    public void initTest() {
        init();
    }

    private void init() {
        User admin = createUser(true);
        User user = createUser(false);

        Role roleAdmin = createRole(true);
        Role roleUser = createRole(false);

        createUserRoleRelation(admin.getId(), roleAdmin.getId());
        createUserRoleRelation(user.getId(), roleUser.getId());

        // 页面权限
        Permission testPagePerm = createPermission("/test", "Test page", 1, "page:test", null, 1, 0L);
        // 按钮权限
        Permission testBtnQueryPerm = createPermission("/**/test", "Test page-query", 2, "btn:test:query", "GET", 1, testPagePerm.getId());
        Permission testBtnPermInsert = createPermission("/**/test", "Test page-add", 2, "btn:test:insert", "POST", 2, testPagePerm.getId());

        Permission monitorOnlinePagePerm = createPermission("/monitor", "Monitor online user pages", 1, "page:monitor:online", null, 2, 0L);
        Permission monitorOnlineBtnQueryPerm = createPermission("/**/api/monitor/online/user", "Online user page-query", 2, "btn:monitor:online:query", "GET", 1, monitorOnlinePagePerm.getId());
        Permission monitorOnlineBtnKickOutPerm = createPermission("/**/api/monitor/online/user/kick-out", "Online user page-kick out", 2, "btn:monitor:online:kick-out", "DELETE", 2, monitorOnlinePagePerm.getId());

        createRolePermissionRelation(roleAdmin.getId(), testPagePerm.getId());
        createRolePermissionRelation(roleUser.getId(), testPagePerm.getId());
        createRolePermissionRelation(roleAdmin.getId(), testBtnQueryPerm.getId());
        createRolePermissionRelation(roleUser.getId(), testBtnQueryPerm.getId());
        createRolePermissionRelation(roleAdmin.getId(), testBtnPermInsert.getId());
        createRolePermissionRelation(roleAdmin.getId(), monitorOnlinePagePerm.getId());
        createRolePermissionRelation(roleAdmin.getId(), monitorOnlineBtnQueryPerm.getId());
        createRolePermissionRelation(roleAdmin.getId(), monitorOnlineBtnKickOutPerm.getId());
    }

    private void createRolePermissionRelation(Long roleId, Long permissionId) {
        RolePermissions adminPage = new RolePermissions();
        RolePermissionsKey adminPageKey = new RolePermissionsKey();
        adminPageKey.setRoleId(roleId);
        adminPageKey.setPermissionId(permissionId);
        adminPage.setId(adminPageKey);
        rolePermissionsRepository.save(adminPage);
    }

    private Permission createPermission(String url, String name, Integer type, String permission, String method, Integer sort, Long parentId) {
        Permission perm = new Permission();
        perm.setId(snowflake.nextId());
        perm.setUrl(url);
        perm.setName(name);
        perm.setType(type);
        perm.setPermission(permission);
        perm.setMethod(method);
        perm.setSort(sort);
        perm.setParentId(parentId);
        permissionRepository.save(perm);
        return perm;
    }

    private void createUserRoleRelation(Long userId, Long roleId) {
        UserRoles userRole = new UserRoles();
        UserRolesKey key = new UserRolesKey();
        key.setUserId(userId);
        key.setRoleId(roleId);
        userRole.setId(key);
        userRolesRepository.save(userRole);
    }

    private Role createRole(boolean isAdmin) {
        Role role = new Role();
        role.setId(snowflake.nextId());
        role.setName(isAdmin ? "Admin" : "User");
        role.setDescription(isAdmin ? "Super Administrator" : "General User");
        role.setCreateTime(DateUtil.current(false));
        role.setUpdateTime(DateUtil.current(false));
        roleRepository.save(role);
        return role;
    }

    private User createUser(boolean isAdmin) {
        User user = new User();
        user.setId(snowflake.nextId());
        user.setUsername(isAdmin ? "admin" : "user");
        user.setNickname(isAdmin ? "Administrator" : "General User");
        user.setPassword(encoder.encode("123456"));
        user.setBirthday(DateTime.of("1994-11-22", "yyyy-MM-dd").getTime());
        user.setEmail((isAdmin ? "admin" : "user") + "@gmail.com");
        user.setPhone(isAdmin ? "17300000000" : "17300001111");
        user.setSex(1);
        user.setStatus(1);
        user.setCreateTime(DateUtil.current(false));
        user.setUpdateTime(DateUtil.current(false));
        userRepository.save(user);
        return user;
    }

}
