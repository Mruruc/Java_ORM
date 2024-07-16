package com.mruruc.optimizations;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;

public class N1EntityGraphSolution {

    public static void main(String[] args) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            EntityGraph<Employee> entityGraph =
                    entityManager.createEntityGraph(Employee.class);
            entityGraph.addAttributeNodes("department");

            entityManager
                    .createQuery("FROM Employee ", Employee.class)
                    .setHint("jakarta.persistence.fetchgraph", entityGraph)
                    .getResultList()
                    .forEach(System.out::println);
        }
        JPAUtil.shutDown();
    }
}
