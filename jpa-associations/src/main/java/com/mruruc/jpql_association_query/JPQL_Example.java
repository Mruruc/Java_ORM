package com.mruruc.jpql_association_query;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Arrays;
import java.util.List;

public class JPQL_Example {
    public static void main(String[] args) {


//        //joins
//        TypedQuery<EmployeeOld> query3 =
//                entityManager.createQuery("SELECT e FROM Employee e WHERE e.card.isActive=true", EmployeeOld.class);
//        List<EmployeeOld> resultList3 = query3.getResultList();
//       // System.out.println(resultList3);


        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            // SELECT first_name,last_name,salary FROM employees as e;
            String query1 = " SELECT e.firstName , e.lastName , e.salary FROM Employee e ";

            String query2 = "SELECT e.firstName , e.lastName , e.salary , d.departmentName FROM Employee e JOIN e.department d";
//            List<Object[]> resultList =
//                    entityManager.createQuery(query2, Object[].class).getResultList();
//
//            for (Object[] arr: resultList){
//                for (Object obj:arr){
//                    System.out.println(obj);
//                }
//                System.out.println(Arrays.toString(arr));
//                System.out.println("======================");
//            }



        } finally {
            JPAUtil.shutDown();
        }


    }
}
