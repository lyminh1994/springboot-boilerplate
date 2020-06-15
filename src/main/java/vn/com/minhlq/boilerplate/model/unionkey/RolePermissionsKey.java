package vn.com.minhlq.boilerplate.model.unionkey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * <p>
 * Role-Permission combined primary key
 * </p>
 */
@Data
@Embeddable
public class RolePermissionsKey implements Serializable {
    private static final long serialVersionUID = 6850974328279713855L;

    /**
     * Role id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * Permission id
     */
    @Column(name = "permission_id")
    private Long permissionId;
}
