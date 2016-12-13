package com.kevin.examples.repository;

import com.kevin.examples.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 11/1/2016.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
