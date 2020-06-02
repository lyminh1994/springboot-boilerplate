package vn.com.minhlq.boilerplate.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * User
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.model
 * @description: Entity User
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: MinhLQ
 */

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String phone;

    private String email;

    private Long birthday;

    /**
     * Sex 1 - Male, 0 - Female
     */
    private Integer sex;

    /**
     * Status 1 - Enable, 0 - Disable
     */
    private Integer status;

    private Long createTime;

    private Long updateTime;
}
