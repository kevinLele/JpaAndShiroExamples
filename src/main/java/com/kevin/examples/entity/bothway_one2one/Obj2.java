package com.kevin.examples.entity.bothway_one2one;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Administrator on 11/2/2016.
 */
@Data
@ToString(exclude = "obj1")
@Entity
@Table(name="obj2")
public class Obj2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(mappedBy = "obj2")
    private Obj1 obj1;
}
