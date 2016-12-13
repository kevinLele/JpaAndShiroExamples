/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.kevin.examples.test;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-14 下午4:25
 * <p>Version: 1.0
 */
@ContextConfiguration({"classpath:applicationContext-test.xml"})
@Transactional(transactionManager="transactionManager")
@Rollback
public abstract class BaseIT extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    protected EntityManager entityManager;


    public void clear() {
        flush();
        entityManager.clear();
    }

    public void flush() {
        entityManager.flush();
    }

}
