package vn.com.minhlq.boilerplate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.com.minhlq.boilerplate.model.UserRoles;
import vn.com.minhlq.boilerplate.model.unionkey.UserRolesKey;

/**
 * <p>
 * User Roles Repository
 * </p>
 */
public interface UserRolesRepository extends JpaRepository<UserRoles, UserRolesKey>, JpaSpecificationExecutor<UserRoles> {

}
