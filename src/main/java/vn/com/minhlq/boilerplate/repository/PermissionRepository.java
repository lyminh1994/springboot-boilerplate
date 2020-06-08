package vn.com.minhlq.boilerplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.minhlq.boilerplate.model.Permission;

import java.util.List;

/**
 * <p>
 * Permission Repository
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.repositories
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {

    /**
     * Query permission list based on list role id
     *
     * @param ids List Role Id
     * @return List permission
     */
    @Query(value = "SELECT DISTINCT permission.* FROM permission, role, role_permissions WHERE role.id = role_permissions.role_id AND permission.id = role_permissions.permission_id AND role.id IN (:ids)", nativeQuery = true)
    List<Permission> selectByRoleIdList(@Param("ids") List<Long> ids);
}
