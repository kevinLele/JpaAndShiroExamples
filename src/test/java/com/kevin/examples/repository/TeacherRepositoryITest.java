package com.kevin.examples.repository;

import com.kevin.examples.entity.Student;
import com.kevin.examples.entity.Teacher;
import com.kevin.examples.test.BaseIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 11/1/2016.
 */
@Slf4j
public class TeacherRepositoryITest extends BaseIT {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testSearch1() {

        Teacher teacher = teacherRepository.findOne(1);

        for (Student student : teacher.getStudentList()) {
            log.warn(student.toString());
        }

        log.warn(teacher.toString());
    }
}
