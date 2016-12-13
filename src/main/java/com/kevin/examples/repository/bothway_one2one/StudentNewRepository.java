package com.kevin.examples.repository.bothway_one2one;

import com.kevin.examples.entity.bothway_one2one.StudentNew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 11/1/2016.
 */
public interface StudentNewRepository extends JpaRepository<StudentNew, Integer>, StudentNewRepositoryCustom {

    List<StudentNew> findByNameNotNull();

    List<StudentNew> findByNameNotNullAndTitleNotNull();

    /**
     *
     如果查询结果确定只有一条则返回类型可以写成如下，如果有多条则会抛出异常
     StudentNew findByNameNotNull();

     */
}
