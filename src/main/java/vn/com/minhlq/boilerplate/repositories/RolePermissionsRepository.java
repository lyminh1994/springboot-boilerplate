package vn.com.minhlq.boilerplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.com.minhlq.boilerplate.model.RolePermissions;
import vn.com.minhlq.boilerplate.model.unionkey.RolePermissionsKey;

/**
 * <p>
 * Role Permissions Repository
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.repositories
 * @description: Role Permissions Repository
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: MinhLQ
 */

public interface RolePermissionsRepository extends JpaRepository<RolePermissions, RolePermissionsKey>, JpaSpecificationExecutor<RolePermissions> {
}
