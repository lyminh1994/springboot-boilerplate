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
@Table(name = "role")
public class Role {
    /**
     * Primary key
     */
    @Id
    private Long id;

    /**
     * Role name
     */
    private String name;

    /**
     * Description
     */
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
