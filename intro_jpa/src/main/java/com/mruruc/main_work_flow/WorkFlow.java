package com.mruruc.main_work_flow;


import com.mruruc.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class WorkFlow {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = new Employee("John", "Doe", "john@doe", 5500.99, LocalDate.now());
        // create
        //entityManager.persist(employee);
        // update
        //  employee.setEmail("john_doe@gmail.com");

        System.out.println(employee);

        // get
//        Employee employee1 = entityManager.find(Employee.class, 1);
//        System.out.println(employee1);

        // delete
        entityManager.remove(
                entityManager.find(Employee.class, 1)
        );

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
