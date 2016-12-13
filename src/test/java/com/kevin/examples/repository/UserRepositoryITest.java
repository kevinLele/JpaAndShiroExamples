package com.kevin.examples.repository;

import com.kevin.examples.entity.Permission;
import com.kevin.examples.entity.Role;
import com.kevin.examples.entity.User;
import com.kevin.examples.test.BaseIT;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;

import java.util.List;

/**
 * Created by Administrator on 11/1/2016.
 */

public class UserRepositoryITest extends BaseIT {

    @Autowired
    private UserRepository repository;

    @Test
    @Commit
    public void testSave(){
        User user = new User();
        user.setBirthday("2017");
        user.setName("aaa1");
        user.setPassword("bbb2");
        repository.save(user);
    }

    @Test
    @Commit
    public void testSave1() {
        User user1 = new User();
        user1.setName("user1");

        User user2 = new User();
        user2.setName("user2");

        Role role1 = new  Role();
        role1.setName("role1");

        Role role2 = new Role();
        role2.setName("role2");

        user1.getRoleList().add(role1);
        user1.getRoleList().add(role2);

        user2.getRoleList().add(role1);
        user2.getRoleList().add(role2);

        repository.save(user1);
        repository.save(user2);
    }

    @Test
    public void testSearch1(){
        User user = repository.findOne(1);

        System.out.println("1111222");

        for (Role role : user.getRoleList()) {
            logger.warn(role.toString());
        }

        System.out.println("3333344444");
    }

    @Test
    public void testSearch2(){
        User user = repository.findByName("zhang");

        if (null != user.getRoleList()) {
            for (Role role : user.getRoleList()) {
                System.out.println(role.getName());

                List<Permission> permissionList = role.getPermissionList();

                if (null != permissionList) {
                    for (Permission permission : permissionList) {
                        System.out.println(permission.getExpression());
                    }
                }
            }
        }
    }
}
