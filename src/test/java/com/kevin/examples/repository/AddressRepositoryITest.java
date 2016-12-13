package com.kevin.examples.repository;

import com.kevin.examples.entity.Address;
import com.kevin.examples.test.BaseIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 11/1/2016.
 */
@Slf4j
public class AddressRepositoryITest extends BaseIT {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSearch1() {

        Address address = addressRepository.findOne(1);

        log.warn(address.toString());
        log.warn(address.getStudent().toString());
    }
}
