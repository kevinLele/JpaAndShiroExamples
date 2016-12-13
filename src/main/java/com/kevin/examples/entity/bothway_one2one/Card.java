package com.kevin.examples.entity.bothway_one2one;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Administrator on 11/3/2016.
 */
@Data
@ToString(exclude = "student")
@Entity
@Table(name = "card_test")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cardNo;

    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "card")*/
    @Transient
    private StudentNew student;
}
