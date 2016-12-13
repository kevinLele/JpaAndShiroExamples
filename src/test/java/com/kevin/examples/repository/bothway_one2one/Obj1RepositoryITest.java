package com.kevin.examples.repository.bothway_one2one;

import com.kevin.examples.entity.bothway_one2one.Obj1;
import com.kevin.examples.entity.bothway_one2one.Obj2;
import com.kevin.examples.test.BaseIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;

/**
 * Created by Administrator on 11/1/2016.
 */
@Slf4j
public class Obj1RepositoryITest extends BaseIT {

    @Autowired
    private Obj1Repository obj1Repository;

    @Test
    @Commit
    public void testSave() {
        Obj1 obj1 = new Obj1();
        obj1.setName("obj1_name");

        Obj2 obj2 = new Obj2();
        obj2.setName("obj2_name");

        obj1.setObj2(obj2);

        obj1Repository.save(obj1);
    }

    @Test
    public void testSearch(){
        Obj1 obj1 = obj1Repository.findOne(1);

        log.warn("验证两个对象是否是同一个内存对象:" + String.valueOf(obj1 == obj1.getObj2().getObj1()));

        log.warn(obj1.toString());
    }
}
