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
 * @version: v1.0
 * @modified: MinhLQ
 */
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    /**
     * Query role list based on user id
     *
     * @param userId User Id
     * @return List<Role>
     */
    @Query(value = "SELECT sec_role.* FROM sec_role,sec_user,sec_user_role WHERE sec_user.id = sec_user_role.user_id AND sec_role.id = sec_user_role.role_id AND sec_user.id = :userId", nativeQuery = true)
    List<Role> selectByUserId(@Param("userId") Long userId);
}
