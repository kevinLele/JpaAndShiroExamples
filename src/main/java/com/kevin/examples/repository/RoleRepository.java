package com.kevin.examples.repository;

import com.kevin.examples.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 10/28/2016.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
