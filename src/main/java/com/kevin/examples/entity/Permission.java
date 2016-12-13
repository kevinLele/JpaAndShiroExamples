package com.kevin.examples.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 11/1/2016.
 */
@Data
@Entity
@Table(name = "permission")
@NamedQuery(name = "Permission.findByTest", query = "select p from Permission p where p.code = ?1")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String code;

    private String expression;
}
