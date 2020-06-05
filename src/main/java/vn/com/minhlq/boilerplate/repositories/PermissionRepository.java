package vn.com.minhlq.boilerplate.repositories;

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
     * Query permission list based on role id list
     *
     * @param ids List Role Id
     * @return List<Permission>
     */
    @Query(value = "SELECT DISTINCT sec_permission.* FROM sec_permission,sec_role,sec_role_permission WHERE sec_role.id = sec_role_permission.role_id AND sec_permission.id = sec_role_permission.permission_id AND sec_role.id IN (:ids)", nativeQuery = true)
    List<Permission> selectByRoleIdList(@Param("ids") List<Long> ids);
}
