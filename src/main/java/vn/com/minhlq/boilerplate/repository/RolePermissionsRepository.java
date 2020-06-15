package vn.com.minhlq.boilerplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.com.minhlq.boilerplate.model.RolePermissions;
import vn.com.minhlq.boilerplate.model.unionkey.RolePermissionsKey;

/**
 * <p>
 * Role Permissions Repository
 * </p>
 */
public interface RolePermissionsRepository extends JpaRepository<RolePermissions, RolePermissionsKey>, JpaSpecificationExecutor<RolePermissions> {
}
