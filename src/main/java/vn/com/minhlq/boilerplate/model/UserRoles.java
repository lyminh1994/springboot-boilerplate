package vn.com.minhlq.boilerplate.model;

import lombok.Data;
import vn.com.minhlq.boilerplate.model.unionkey.UserRolesKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * User role association
 * </p>
 */
@Data
@Entity
@Table(name = "user_roles")
public class UserRoles {
    /**
     * Primary key
     */
    @EmbeddedId
    private UserRolesKey id;
}
