package com.kevin.examples.repository.bothway_one2one;

import com.kevin.examples.entity.bothway_one2one.Card;
import com.kevin.examples.entity.bothway_one2one.StudentNew;
import com.kevin.examples.test.BaseIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;

import java.util.List;

/**
 * Created by Administrator on 11/1/2016.
 */
@Slf4j
public class StudentRepositoryITest extends BaseIT {

    @Autowired
    private StudentNewRepository studentNewRepository;

    @Test
    @Commit
    public void testSave() {

        StudentNew student = new StudentNew();
        Card card = new Card();
        card.setCardNo("123");

        student.setName("student name");
        student.setTitle("title");
        student.setCard(card);


        studentNewRepository.save(student);
    }

    @Test
    public void testSearch() {

        StudentNew student = studentNewRepository.findOne(3);

        log.warn(student.toString());
        log.warn(student.getCard().toString());
    }

    @Test
    public void testFindByNameNotNull() {

        List<StudentNew> students = studentNewRepository.findByNameNotNull();

        log.warn("*******************size:" + students.size());
    }

    @Test
    public void testFindByNameNotNullAndTitleNotNull() {

        List<StudentNew> students = studentNewRepository.findByNameNotNullAndTitleNotNull();

        log.warn("*******************size:" + students.size());
    }

    @Test
    public void testSomeCustomMethod(){
        studentNewRepository.someCustomMethod(null);
    }

}
