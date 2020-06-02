package vn.com.minhlq.boilerplate.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Permission
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.model
 * @description: Entity Permission
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: MinhLQ
 */

@Data
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    private Long id;

    private String name;

    /**
     * When the type is page, it represents the front-end routing address, and when the type is button, it represents the back-end interface address
     */
    private String url;

    /**
     * Permission type 1 - Page, 2 - Button
     */
    private Integer type;

    /**
     * Permission expression
     */
    private String permission;

    /**
     * Backend interface access method
     */
    private String method;

    /**
     * Sort
     */
    private Integer sort;

    /**
     * Parent Id
     */
    @Column(name = "parent_id")
    private Long parentId;
}
