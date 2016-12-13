package com.kevin.examples.repository.bothway_one2one;

import com.kevin.examples.entity.bothway_one2one.Card;
import com.kevin.examples.entity.bothway_one2one.Card_;
import com.kevin.examples.entity.bothway_one2one.StudentNew;
import com.kevin.examples.entity.bothway_one2one.StudentNew_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 11/4/2016.
 */
public class StudentNewRepositoryImpl implements StudentNewRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    public void someCustomMethod(StudentNew studentNew) {
        //// TODO: 11/7/2016 JPA动态查询样例

        /*Query query1 = em.createQuery("select s from StudentNew s");
        List result1 = query1.getResultList();

        for (Object obj : result1) {
            StudentNew studentNew1 = (StudentNew)obj;
            System.out.println(studentNew1);
        }*/

        System.out.println("/*******************************1*************************/");

        /*Query query2 = em.createQuery("select s from StudentNew s inner join fetch s.card c where c.cardNo = :cardNo");*/
        /*Query query2 = em.createQuery("select s from StudentNew s ,Card c where s.card=c.id and c.cardNo = :cardNo");
        query2.setParameter("cardNo","123");

        List result2 = query2.getResultList();

        for (Object obj : result2) {
            StudentNew studentNew2 = (StudentNew)obj;
            System.out.println(studentNew2);
        }*/

        System.out.println("/*******************************2*************************/");

        /*TypedQuery<StudentNew> query3 = em.createQuery("select s from StudentNew s ,Card c where s.card=c.id and c.cardNo = :cardNo",StudentNew.class);
        query3.setParameter("cardNo","123");

        List<StudentNew> result3 = query3.getResultList();

        for (StudentNew std : result3) {
            System.out.println(std);
        }*/

        System.out.println("/*******************************3*************************/");

        CriteriaBuilder cb4 = em.getCriteriaBuilder();
        CriteriaQuery<StudentNew> cq4 = cb4.createQuery(StudentNew.class);
        Root<StudentNew> root1 = cq4.from(StudentNew.class);
        /*Root<StudentNew> root2 = cq4.from(StudentNew.class);*/

        Join<StudentNew,Card> card = root1.join(StudentNew_.card);

        //root.join(root.getModel().getSingularAttribute(""));

        //cq4.multiselect(root1,root2);
        cq4.select(root1);
        cq4.where(cb4.like(root1.get(StudentNew_.name), "%name2%"));
        cq4.where(cb4.like(card.get(Card_.cardNo),"%123%"));

        TypedQuery<StudentNew> q4 = em.createQuery(cq4);
        List<StudentNew> result4 = q4.getResultList();

        for (StudentNew std : result4) {
            System.out.println(std);
        }

        System.out.println("/*******************************4*************************/");

        /*String dataSql = "select t from User t where 1 = 1";
        String countSql = "select count(t) from User t where 1 = 1";

        if(null != user && !StringUtils.isEmpty(user.getName())) {
            dataSql += " and t.name = ?1";
            countSql += " and t.name = ?1";
        }

        Query dataQuery = em.createQuery(dataSql);
        Query countQuery = em.createQuery(countSql);

        if(null != user && !StringUtils.isEmpty(user.getName())) {
            dataQuery.setParameter(1, user.getName());
            countQuery.setParameter(1, user.getName());
        }long totalSize = (long) countQuery.getSingleResult();
        Page<User> page = new Page();
        page.setTotalSize(totalSize);
        List<User> data = dataQuery.getResultList();
        page.setData(data);
        return page;*/

        System.out.println(em.toString() + "--------------------someCustomMethod**********************");
    }
}
