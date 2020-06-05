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
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Data
@Entity
@Table(name = "sec_role_permission")
public class RolePermissions {
    /**
     * Primary key
     */
    @EmbeddedId
    private RolePermissionsKey id;
}
