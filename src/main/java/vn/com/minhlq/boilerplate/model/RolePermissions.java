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
 */
@Data
@Entity
@Table(name = "role_permissions")
public class RolePermissions {
    /**
     * Primary key
     */
    @EmbeddedId
    private RolePermissionsKey id;
}
