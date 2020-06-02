package vn.com.minhlq.boilerplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.minhlq.boilerplate.model.Role;

import java.util.List;

/**
 * <p>
 * Role Repository
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.repositories
 * @description: Role Repository
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: MinhLQ
 */

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    /**
     * Query role list based on user id
     *
     * @param userId User Id
     * @return List<Role>
     */
    @Query(value = "SELECT role.* FROM role, user ,user_roles WHERE user.id = user_roles.user_id AND role.id = user_roles.role_id AND user.id = :userId", nativeQuery = true)
    List<Role> selectByUserId(@Param("userId") Long userId);
}
