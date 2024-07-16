package com.mruruc.entityRelationship;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.AccessCard;
import com.mruruc.model.Employee;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class Read {
    public static void main(String[] args) {

        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {

            // if in association fetch type is lazy and as long as do not access instance of the association,
            // hibernate will not make another select request.
/**
 *             Hibernate:
 *             select
 *             e1_0.employee_id,
 *                     e1_0.access_card_id,
 *                     e1_0.email,
 *                     e1_0.first_name,
 *                     e1_0.gender,
 *                     e1_0.hire_date,
 *                     e1_0.last_name,
 *                     e1_0.salary
 *             from
 *             public.employees e1_0
 *             where
 *             e1_0.employee_id=?
 */

//            // find
//            Employee employee1 = entityManager.find(Employee.class, 2L);
//            System.out.println(employee1.getEmployeeId());
//            System.out.println(employee1.getFirstName());
//            System.out.println(employee1.getLastName());
//            System.out.println("==========================");
//            // even though we access the getAccessCard id it will not make another database call
//            System.out.println(employee1.getAccessCard().getCardId());
//            System.out.println("=====================================");
//            AccessCard accessCard = employee1.getAccessCard();
//            System.out.println(accessCard.getCardId());
//            // but if we access the other field than Id we will cause another select statement to db.
//            System.out.println(accessCard.getIsActive());
//            System.out.println(accessCard.getIssuedDate());
//           // AccessCard accessCard1 = entityManager.find(AccessCard.class, 1L);

//            TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ", Employee.class);
//            query.getResultList()
//                    .forEach(e -> System.out.println(e.getFirstName() + " " + e.getDepartment().getDepartmentName()));

        }
        JPAUtil.shutDown();

    }
}
