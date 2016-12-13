package com.kevin.examples.restful2;

import com.kevin.examples.entity.User;
import com.kevin.examples.repository.UserRepository;
import com.kevin.examples.service.TestService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 11/21/2016.
 */
@Component
@Path("/hello2")
public class Hello2Restful {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestService testService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateResource/{throwException}")
    public String updateResource(@PathParam("throwException")boolean throwException) {
        /*boolean throwException = Boolean.parseBoolean(throwExceptionStr);*/

        testService.testCheck(throwException);

        return "{hello2:1}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("updateResource2") 不设置path的情况下如果要调用该方法直接访问/hello
    public String updateResource2() {
        return "{hello2:2}";
    }

    @GET
    @Path("{id}/getResource")
    @RequiresPermissions(value={"user:user:views"})
    public String updateResource3(@PathParam("id") String id) {
        Subject subject = SecurityUtils.getSubject();
        System.out.println("before ---------------------isAuthenticated:" + subject.isAuthenticated());

        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
            subject.login(token);
        }

        System.out.println("after ---------------------isAuthenticated:" + subject.isAuthenticated());

        User user = userRepository.findOne(Integer.parseInt(id));
        return "{hello2:" + user.getName() + "}";
    }
}
