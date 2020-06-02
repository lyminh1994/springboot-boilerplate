package vn.com.minhlq.boilerplate.model.unionkey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * <p>
 * User Roles Key
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.model.unionkey
 * @description: Union key of table User Roles
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: MinhLQ
 */

@Data
@Embeddable
public class UserRolesKey implements Serializable {
    private static final long serialVersionUID = 0L;

    @Column(name = "user_id")
    private Long userId;


    @Column(name = "role_id")
    private Long roleId;
}
