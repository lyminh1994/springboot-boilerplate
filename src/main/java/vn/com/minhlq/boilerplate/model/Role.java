package vn.com.minhlq.boilerplate.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Role
 * </p>
 */
@Data
@Entity
@Table(name = "role")
public class Role {

    /**
     * Primary key
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Role name
     */
    @Column(name = "name")
    private String name;

    /**
     * Description
     */
    @Column(name = "description")
    private String description;

    /**
     * Create time
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * Update time
     */
    @Column(name = "update_time")
    private Long updateTime;

}
