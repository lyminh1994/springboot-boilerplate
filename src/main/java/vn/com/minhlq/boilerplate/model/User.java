package vn.com.minhlq.boilerplate.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * User
 * </p>
 */
@Data
@Entity
@Table(name = "user")
public class User {

    /**
     * Primary key
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Username
     */
    @Column(name = "username")
    private String username;

    /**
     * Password
     */
    @Column(name = "password")
    private String password;

    /**
     * Nickname
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * Phone number
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Email
     */
    @Column(name = "email")
    private String email;

    /**
     * Birthday
     */
    @Column(name = "birthday")
    private Long birthday;

    /**
     * Gender, male-1, female-2
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * Status, enable-1, disable-0
     */
    @Column(name = "status")
    private Integer status;

    /**
     * Creation time
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * Update time
     */
    @Column(name = "update_time")
    private Long updateTime;
}
