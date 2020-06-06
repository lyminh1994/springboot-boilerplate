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
@Table(name = "user_roles")
public class UserRoles {
    /**
     * Primary key
     */
    @EmbeddedId
    private UserRolesKey id;
}
