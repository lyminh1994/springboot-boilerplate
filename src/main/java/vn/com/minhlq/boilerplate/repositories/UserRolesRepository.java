package vn.com.minhlq.boilerplate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.com.minhlq.boilerplate.model.UserRoles;
import vn.com.minhlq.boilerplate.model.unionkey.UserRolesKey;

/**
 * <p>
 * User Roles Repository
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.repositories
 * @description: User Roles Repository
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
public interface UserRolesRepository extends JpaRepository<UserRoles, UserRolesKey>, JpaSpecificationExecutor<UserRoles> {

}
