package vn.com.minhlq.boilerplate.repository;

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
 */
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    /**
     * Query role list based on user id
     *
     * @param userId User Id
     * @return List role
     */
    @Query(value = "SELECT role.* FROM role, user, user_roles WHERE user.id = user_roles.user_id AND role.id = user_roles.role_id AND user.id = :userId", nativeQuery = true)
    List<Role> selectByUserId(@Param("userId") Long userId);
}
