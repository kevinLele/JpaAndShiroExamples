package com.kevin.examples.service;

import com.kevin.examples.entity.User;

import java.util.Set;

/**
 * Created by Administrator on 11/30/2016.
 */
public interface UserService {

    User findByName(String name);

    Set<String> getPermissionStringsByUserName(String name);

    Set<String> getRoleStringsByUserName(String name);
}
