package com.kevin.examples.repository;

import com.kevin.examples.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 11/1/2016.
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
