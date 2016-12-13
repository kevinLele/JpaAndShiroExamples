package com.kevin.examples.repository;

import com.kevin.examples.entity.Permission;
import com.kevin.examples.entity.QPermission;
import com.kevin.examples.entity.projection.PermissionVO;
import com.kevin.examples.test.BaseIT;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Commit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;

import static org.springframework.data.jpa.domain.Specifications.*;

/**
 * Created by Administrator on 11/1/2016.
 */
@Slf4j
public class PermissionRepositoryITest extends BaseIT {

    @Autowired
    private PermissionRepository permissionRepository;

    @Test
    @Commit
    public void testSave() {

        Permission permission1 = new Permission();
        Permission permission2 = new Permission();
        Permission permission3 = new Permission();
        Permission permission4 = new Permission();
        Permission permission5 = new Permission();
        Permission permission6 = new Permission();
        Permission permission7 = new Permission();
        Permission permission8 = new Permission();
        Permission permission9 = new Permission();
        Permission permission10 = new Permission();
        Permission permission11 = new Permission();
        Permission permission12 = new Permission();
        Permission permission13 = new Permission();
        Permission permission14 = new Permission();
        Permission permission15 = new Permission();
        Permission permission16 = new Permission();

        permission1.setName("name1");
        permission1.setCode("code1");
        permission2.setName("name2");
        permission2.setCode("code2");
        permission3.setName("name3");
        permission3.setCode("code3");
        permission4.setName("name4");
        permission4.setCode("code4");
        permission5.setName("name5");
        permission5.setCode("code5");
        permission6.setName("name6");
        permission6.setCode("code6");
        permission7.setName("name7");
        permission7.setCode("code7");
        permission8.setName("name8");
        permission8.setCode("code8");
        permission9.setName("name9");
        permission9.setCode("code9");
        permission10.setName("name10");
        permission10.setCode("code10");
        permission11.setName("name11");
        permission11.setCode("code11");
        permission12.setName("name12");
        permission12.setCode("code12");
        permission13.setName("name13");
        permission13.setCode("code13");
        permission14.setName("name14");
        permission14.setCode("code14");
        permission15.setName("name15");
        permission15.setCode("code15");
        permission16.setName("name16");
        permission16.setCode("code16");

        permissionRepository.save(permission1);
        permissionRepository.save(permission2);
        permissionRepository.save(permission3);
        permissionRepository.save(permission4);
        permissionRepository.save(permission5);
        permissionRepository.save(permission6);
        permissionRepository.save(permission7);
        permissionRepository.save(permission8);
        permissionRepository.save(permission9);
        permissionRepository.save(permission10);
        permissionRepository.save(permission11);
        permissionRepository.save(permission12);
        permissionRepository.save(permission13);
        permissionRepository.save(permission14);
        permissionRepository.save(permission15);
        permissionRepository.save(permission16);
    }

    @Test
    public void testPage() {

        Sort.Order nameOrder = new Sort.Order(Sort.Direction.ASC, "name");
        Sort.Order codeOrder = new Sort.Order(Sort.Direction.DESC, "code");
        Sort sort = new Sort(nameOrder, codeOrder);
        PageRequest pageRequest = new PageRequest(1, 10, sort);

        Page<Permission> pageRsp = permissionRepository.findAll(pageRequest);
        Iterator<Permission> it = pageRsp.iterator();

        while (it.hasNext()) {
            Permission permission = it.next();
            System.out.println(permission.toString());
        }
    }

    @Test
    public void testSort() {

        Sort.Order nameOrder = new Sort.Order(Sort.Direction.ASC, "name");
        Sort.Order codeOrder = new Sort.Order(Sort.Direction.DESC, "code");
        Sort sort = new Sort(nameOrder, codeOrder);

        List<Permission> list = permissionRepository.findAll(sort);

        for (Permission permission : list) {
            System.out.println(permission.toString());
        }
    }

    @Test
    public void testFindByName() {

        PermissionVO vo = permissionRepository.findByName("name1");
        System.out.println(vo);
    }

    @Test
    public void testFindByNameOrderByCodeDesc() {

        List<Permission> results = permissionRepository.findTop3ByNameLikeOrderByCodeDesc("%name%");

        for (Permission p : results) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testPredicate() {

        QPermission permission = QPermission.permission;
        Predicate predicate = permission.name.containsIgnoreCase("name1").and(permission.code.containsIgnoreCase("code2"));

        Iterable<Permission> results = permissionRepository.findAll(predicate);

        for (Permission p : results) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByTest() {

        List<Permission> results = permissionRepository.findByTest("code1");

        for (Permission p : results) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testFindByTestQuery() {

        List<Permission> results = permissionRepository.findByTestQuery("code1", "name1");

        for (Permission p : results) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testFindByTestQueryNative() {

        List<Permission> results = permissionRepository.findByTestQueryNative("code1", "name1");

        for (Permission p : results) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testFindByParamName() {

        List<Permission> results = permissionRepository.findByParamName("name1", "code1");

        for (Permission p : results) {
            System.out.println(p.toString());
        }
    }

    @Test
    @Commit
    public void testSetName() {

        permissionRepository.setName("name2***", "code2");
    }

    /**
     * 测试通过构造Predicate的方式进行查询
     */
    @Test
    public void testSpecificationExecutor() {

        List<Permission> results = permissionRepository.findAll(new Specification<Permission>() {

            public javax.persistence.criteria.Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                return criteriaBuilder.like(root.<String>get("name"), "%name2%");
                //这种方式也可以 root.get("name").as(String.class)
            }
        });

        for (Permission p : results) {
            System.out.println(p.toString());
        }
    }

    /**
     * 多条件查询
     */
    @Test
    public void testMoreSpecificationExecutor() {

        List<Permission> results = permissionRepository.findAll(where(new Specification<Permission>() {

            public javax.persistence.criteria.Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                return criteriaBuilder.like(root.<String>get("name"), "%name2%");
                //这种方式也可以 root.get("name").as(String.class)
            }
        }).or(new Specification<Permission>() {

            public javax.persistence.criteria.Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                return criteriaBuilder.like(root.<String>get("name"), "%name3%");
            }
        }));

        for (Permission p : results) {
            System.out.println(p.toString());
        }
    }
}
