package vn.com.minhlq.boilerplate.model;


import lombok.Data;
import vn.com.minhlq.boilerplate.model.unionkey.RolePermissionsKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * Role Permissions
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.model
 * @description: Entity Role Permissions
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: MinhLQ
 */

@Data
@Entity
@Table(name = "role_permissions")
public class RolePermissions {

    @EmbeddedId
    private RolePermissionsKey id;
}
