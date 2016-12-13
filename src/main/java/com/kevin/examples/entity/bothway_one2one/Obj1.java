package com.kevin.examples.entity.bothway_one2one;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Administrator on 11/2/2016.
 */
@Data
@Entity
@Table(name="obj1")
public class Obj1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="obj2Id",nullable = false)
    private Obj2 obj2;
}
