package com.kevin.examples.repository.bothway_one2one;

import com.kevin.examples.entity.bothway_one2one.Card;
import com.kevin.examples.test.BaseIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 11/1/2016.
 */
@Slf4j
public class CardRepositoryITest extends BaseIT {

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void testSearch() {

        Card card = cardRepository.findOne(3);

        log.warn(card.toString());
        //log.warn(card.getStudent().toString());
    }
}
