package com.kevin.examples.repository;

import com.kevin.examples.entity.Address;
import com.kevin.examples.entity.Student;
import com.kevin.examples.entity.Teacher;
import com.kevin.examples.entity.enums.SexEnum;
import com.kevin.examples.test.BaseIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;

/**
 * Created by Administrator on 11/1/2016.
 */
@Slf4j
public class StudentRepositoryITest extends BaseIT {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Commit
    public void testSave() {

        Teacher teacher = new Teacher();
        teacher.setName("严老师");

        Address address1 = new Address();
        address1.setCompanyAddress("公司地址");
        address1.setHomeAddress("家庭地址");
        address1.setEmailAddress("email@com.con");
        address1.setPostalAddress("邮政地址");

        Student student = new Student();

        student.setName("张三");
        student.setSex(SexEnum.FEMALE);
        student.setPhone("15801010001");
        student.setAddress(address1);
        student.setTeacher(teacher);

        Address address2 = new Address();
        address2.setCompanyAddress("公司地址2");
        address2.setHomeAddress("家庭地址2");
        address2.setEmailAddress("email@com.con2");
        address2.setPostalAddress("邮政地址2");

        Student student2 = new Student();

        student2.setName("张三2");
        student2.setSex(SexEnum.FEMALE);
        student2.setPhone("15801010002");
        student2.setAddress(address2);
        student2.setTeacher(teacher);

        Student student3 = new Student();

        student3.setName("张三3");
        student3.setSex(SexEnum.MALE);
        student3.setPhone("15801010003");
        student3.setAddress(address2);
        student3.setTeacher(teacher);

        studentRepository.save(student);
        studentRepository.save(student2);
        studentRepository.save(student3);
    }

    @Test
    public void testSearch1(){
        Student student = studentRepository.findOne(3);
        log.warn(student.toString());
    }
}
