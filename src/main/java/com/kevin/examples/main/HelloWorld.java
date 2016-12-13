package com.kevin.examples.main;

import com.kevin.examples.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Created by Administrator on 10/27/2016.
 */
@Slf4j
public class HelloWorld {

    public static void println() {

        System.out.println("testa a bv a");
        log.trace("Hello World!");
        log.debug("How are you today?");
        log.info("I am fine.");
        log.warn("I love programming.");
        log.error("I am programming.");
        RuntimeException re = new RuntimeException("test");
        log.error("测试抛异常的情况", re);
    }

    public static void main(String[] args) {
        //println();
        testSpring();
    }

    /*public static void testTransational(){
        JpaRealm realm = ContextLoaderListener.getCurrentWebApplicationContext().getBean("jpaRealmTest", JpaRealm.class);
        JpaRealm realm2 = ContextLoaderListener.getCurrentWebApplicationContext().getBean("jpaRealm", JpaRealm.class);
        realm.testTransational();
    }*/

    public static void testSpring() {
        //HelloWorld helloWorld = (HelloWorld) ContextLoaderListener.getCurrentWebApplicationContext().getBean("helloWorld");
        //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserRepository repository = ContextLoaderListener.getCurrentWebApplicationContext().getBean("userRepository", UserRepository.class);

        /*User user = new User();
        user.setBirthday("2016");
        user.setName("aaa2");
        user.setPassword("bbb");
        repository.save(user);*/

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        //UsernamePasswordToken token = new UsernamePasswordToken("zhang","202cb962ac59075b964b07152d234b70");
        subject.login(token);

        System.out.println(repository);
    }

}
