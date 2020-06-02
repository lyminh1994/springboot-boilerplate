package vn.com.minhlq.boilerplate.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {

    @CreatedBy
    @Column(name = "CREATE_BY")
    private String createBy;

    @CreatedDate
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @LastModifiedBy
    @Column(name = "UPDATE_BY")
    private String updateBy;
    @LastModifiedDate
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

}
