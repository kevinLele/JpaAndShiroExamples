package com.kevin.examples.repository;

import com.kevin.examples.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 10/28/2016.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
}
