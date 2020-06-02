package vn.com.minhlq.boilerplate.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Role
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.model
 * @description: Entity Role
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: MinhLQ
 */

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    private Long id;

    private String name;

    private String description;

}
