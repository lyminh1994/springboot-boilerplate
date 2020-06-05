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
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Data
@Entity
@Table(name = "sec_permission")
public class Permission {
    /**
     * Primary key
     */
    @Id
    private Long id;

    /**
     * Permission name
     */
    private String name;

    /**
     * When the type is page, it represents the front-end routing address, and when the type is button, it represents the back-end interface address
     */
    private String url;

    /**
     * Permission type, page-1, button-2
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
     * Parent id
     */
    @Column(name = "parent_id")
    private Long parentId;
}
