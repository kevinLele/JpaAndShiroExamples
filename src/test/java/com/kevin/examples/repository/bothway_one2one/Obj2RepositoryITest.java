package com.kevin.examples.repository.bothway_one2one;

import com.kevin.examples.entity.bothway_one2one.Obj2;
import com.kevin.examples.test.BaseIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 11/1/2016.
 */
@Slf4j
public class Obj2RepositoryITest extends BaseIT {

    @Autowired
    private Obj2Repository obj2Repository;

    @Test
    public void testSearch(){
        Obj2 obj2 = obj2Repository.findOne(1);

        log.warn(obj2.toString());
        log.warn(obj2.getObj1().toString());
    }
}
