package com.kevin.examples.entity.bothway_one2one;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Administrator on 11/3/2016.
 */
@Data
/*@ToString(exclude = "card")*/
@EqualsAndHashCode(exclude = "card")
@Entity
@Table(name = "student_test")
public class StudentNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String title;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;


    @PrePersist
    public void preSave(){

        System.out.println("*************************preSaves*********************");
    }
}
