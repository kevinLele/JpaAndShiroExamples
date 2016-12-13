package com.kevin.examples.service;

import com.kevin.examples.service.impl.TestServiceImpl;
import com.kevin.examples.test.BaseIT;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Administrator on 11/15/2016.
 */
@Slf4j
public class LoginTest extends BaseIT {
    @Autowired
    @Qualifier("testService")
    private TestServiceImpl testService1;

    @Autowired
    private TestService testService2;

    @Test
    public void testJDBCRealm() {
        //得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            log.error( "User [" + subject.getPrincipal() + "] ." );
            log.error("User password:" + String.valueOf(token.getPassword()));

            //testService1.testCheck();

            //4、登录，即身份验证
            subject.login(token);
            log.error( "User [" + subject.getPrincipal() + "] logged in successfully." );

            log.error("has role:" + subject.hasRole("role1"));
            subject.checkPermission("user:update:views");

            testService1.testCheck(true);
        } catch (ShiroException e) {
            //5、身份验证失败
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }
}
