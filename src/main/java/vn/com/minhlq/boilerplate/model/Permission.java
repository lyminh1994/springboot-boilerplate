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
 */
@Data
@Entity
@Table(name = "permission")
public class Permission {
    /**
     * Primary key
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Permission name
     */
    @Column(name = "name")
    private String name;

    /**
     * When the type is page, it represents the front-end routing address, and when the type is button, it represents the back-end interface address
     */
    @Column(name = "url")
    private String url;

    /**
     * Permission type, page-1, button-2
     */
    @Column(name = "type")
    private Integer type;

    /**
     * Permission expression
     */
    @Column(name = "permission")
    private String permission;

    /**
     * Backend interface access method
     */
    @Column(name = "method")
    private String method;

    /**
     * Sort
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * Parent id
     */
    @Column(name = "parent_id")
    private Long parentId;
}
