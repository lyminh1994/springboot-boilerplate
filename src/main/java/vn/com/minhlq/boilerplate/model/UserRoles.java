package vn.com.minhlq.boilerplate.model;

import lombok.Data;
import vn.com.minhlq.boilerplate.model.unionkey.UserRolesKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * User Roles
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.model
 * @description: Entity User Roles
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: MinhLQ
 */

@Data
@Entity
@Table(name = "user_roles")
public class UserRoles {

    @EmbeddedId
    private UserRolesKey id;
}
