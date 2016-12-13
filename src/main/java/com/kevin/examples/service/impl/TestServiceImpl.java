package com.kevin.examples.service.impl;

import com.kevin.examples.entity.User;
import com.kevin.examples.repository.UserRepository;
import com.kevin.examples.service.TestService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 11/17/2016.
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private UserRepository userRepository;

    @RequiresAuthentication
    @RequiresPermissions(value={"user:user:views"})
    public void testCheck(boolean throwException){
        User user1 = new User();
        user1.setName("test1");

        User user2 = new User();
        user2.setName("test2");

        userRepository.save(user1);

        userRepository.save(user2);

        if (throwException) {
            //throw new RuntimeException("test Exception rollback");
        }

        System.out.println("test check");
    }
}
