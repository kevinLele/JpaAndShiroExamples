package com.kevin.examples.service.impl;

import com.kevin.examples.entity.Permission;
import com.kevin.examples.entity.Role;
import com.kevin.examples.entity.User;
import com.kevin.examples.repository.UserRepository;
import com.kevin.examples.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 11/30/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "userCache")
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Cacheable(value = "roleCache")
    public Set<String> getRoleStringsByUserName(String name) {
        User user = findByName(name);

        /*if(null != AopContext.currentProxy()){
            user = ((UserService)AopContext.currentProxy()).findByName(name);
        }else{
            findByName(name);
        }*/

        Set<String> roleNames = new LinkedHashSet<String>();
        List<Role> roleList = user.getRoleList();

        if (null != roleList) {
            for (Role role : roleList) {
                roleNames.add(role.getName());
            }
        }

        return roleNames;
    }

    @Cacheable(value = "permissionCache")
    public Set<String> getPermissionStringsByUserName(String name) {
        User user = findByName(name);

        Set<String> permissions = new LinkedHashSet<String>();
        List<Role> roleList = user.getRoleList();

        if (null != roleList) {
            for (Role role : roleList) {
                List<Permission> permissionList = role.getPermissionList();

                if (null != permissionList) {
                    for (Permission permission : permissionList) {
                        permissions.add(permission.getExpression());
                    }
                }
            }
        }

        return permissions;
    }

    private UserService current(){
        if(null != AopContext.currentProxy()){
            return (UserService)AopContext.currentProxy();
        }else{
            return this;
        }
    }
}
