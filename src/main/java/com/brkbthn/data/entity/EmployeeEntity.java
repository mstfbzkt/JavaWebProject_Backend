package com.brkbthn.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="employee")
public class EmployeeEntity extends BaseEntiity implements Serializable {
    public static final long serialVersionUID=1L;
 /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement

  */
    //private Long id;
    private String username;
    private String email;
    private String pasword;
    private double price;
/*
    //date ekleyelim
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

 */
}
