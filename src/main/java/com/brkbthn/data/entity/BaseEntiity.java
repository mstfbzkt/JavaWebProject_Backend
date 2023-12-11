package com.brkbthn.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//Lombok
@Getter
@Setter
//Super class
@MappedSuperclass
//Auditing
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date, update_date"}, allowGetters = true)
public class BaseEntiity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    //Kim ekledi
    @Column(name ="created_by")
    @CreatedBy
    private String createdBy;

    //kim ne zaman ekledi
    @Column(name = "created_user_date")
    @CreatedDate
    private Date createdDate;

    //Kim güncelledi
    @Column(name = "updated_by")
    @LastModifiedBy
    private String updateBy;


    //kim ne zaman güncelledi
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;


    //şimdiki zamanı verir
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCtreateDate;


}
