package vn.com.minhlq.boilerplate.model.unionkey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * <p>
 * User-Roles combined primary key
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
@Embeddable
public class UserRolesKey implements Serializable {
    private static final long serialVersionUID = 5633412144183654743L;

    /**
     * User id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * Role id
     */
    @Column(name = "role_id")
    private Long roleId;
}
