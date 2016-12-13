package com.kevin.examples.entity;

import com.kevin.examples.entity.enums.SexEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 11/1/2016.
 */
@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别
     */
    @Enumerated(EnumType.ORDINAL)
    private SexEnum sex;

    /**
     * 地址信息
     */
    /**
     * 注解说明：
     * 这里的nullable为false表示cid不能为空，说明SQL发行的是inner join而不是left join
     * fetch为LAZY表示延时加载，这样在查询的时候只会查一张表而不会进行两个表的关联查询，直到调用address的方法时才会再触发进行数据库查询
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId", nullable = false)
    private Address address;

    /**
     * 学生对应的老师，目前这种关系表明一个学生只有一个对应的老师，学生跟老师是多对一的关系
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId", nullable = false)
    private Teacher teacher;
}
