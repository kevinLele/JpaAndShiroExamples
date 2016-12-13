package com.kevin.examples.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 11/1/2016.
 */
@Data
@ToString(exclude = "student")
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 通信地址
     */
    private String postalAddress;

    /**
     * 邮箱地址
     */
    private String emailAddress;

    /**
     * 双向关联的OneToOne
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")
    private Student student;

}
