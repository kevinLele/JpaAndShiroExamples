package com.kevin.examples.repository;

import com.kevin.examples.entity.Permission;
import com.kevin.examples.entity.projection.PermissionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 10/28/2016.
 */

public interface PermissionRepository extends JpaRepository<Permission, Integer>
        , QueryDslPredicateExecutor<Permission>
        , JpaSpecificationExecutor<Permission> {

    /**
     * 测试投影属性的情况
     *
     * @param name
     * @return
     */
    PermissionVO findByName(String name);

    /**
     * 截取部分数据， 以like方式查询，支持排序
     *
     * @param name
     * @return
     */
    List<Permission> findTop3ByNameLikeOrderByCodeDesc(String name);

    List<Permission> findByTest(String test);

    /**
     * 通过@Query设置查询语句
     *
     * @param test
     * @param name
     * @return
     */
    @Query("select p from Permission p where p.code like ?1 and p.name = ?2")
    List<Permission> findByTestQuery(String test, String name);

    /**
     * 通过直接设置SQL的方式
     *
     * @param test
     * @param name
     * @return
     */
    @Query(value = "select * from permission where code like ?1 and name = ?2", nativeQuery = true)
    List<Permission> findByTestQueryNative(String test, String name);

    /**
     * 以参数的型式传叁数
     *
     * @param name
     * @param code
     * @return
     */
    @Query("select p from #{#entityName} p where p.code like :code and p.name = :name")
    List<Permission> findByParamName(@Param("name") String name, @Param("code") String code);

    /**
     * 学习修改
     *
     * @param name
     * @param code
     * @return
     */
    @Modifying
    @Query("update #{#entityName} p set p.name = :name where p.code = :code")
    int setName(@Param("name") String name, @Param("code") String code);
}
