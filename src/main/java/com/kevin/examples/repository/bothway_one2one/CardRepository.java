package com.kevin.examples.repository.bothway_one2one;

import com.kevin.examples.entity.bothway_one2one.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 11/1/2016.
 */
public interface CardRepository extends JpaRepository<Card, Integer> {

}
