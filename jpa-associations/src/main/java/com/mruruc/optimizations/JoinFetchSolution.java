package com.mruruc.optimizations;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import jakarta.persistence.EntityManager;

public class JoinFetchSolution {
    public static void main(String[] args) {

        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {

            entityManager
                    .createQuery("FROM Employee e join fetch e.department", Employee.class)
                    .getResultList().forEach(System.out::println);
        }finally {
            JPAUtil.shutDown();
        }
    }
}
