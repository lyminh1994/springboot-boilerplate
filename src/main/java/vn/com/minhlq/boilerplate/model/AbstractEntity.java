package vn.com.minhlq.boilerplate.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * <p>
 * Abstract Entity
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.model
 * @description: Entity Permission
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @CreatedBy
    @Column(name = "create_by")
    private String createBy;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updateBy;

    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;

}
