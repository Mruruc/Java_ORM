package com.mruruc.entityRelationship;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.AccessCard;
import com.mruruc.model.Department;
import com.mruruc.model.Employee;
import com.mruruc.model.Gender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Create {
    public static void main(String[] args) {

        var employee = new Employee("John", "Doe", Gender.MALE, "john_doe@gmail.com", 5000.00, LocalDate.now());
        var department = new Department();
        department.setDepartmentId(6L);
        employee.setDepartment(department);

        var accessCard = new AccessCard(LocalDate.now(), true, "0.0.1");

        employee.setAccessCard(accessCard);
        accessCard.setEmployee(employee);

        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            // save
           // entityManager.persist(employee);
            //  accessCard.setEmployee(employee);
            // entityManager.persist(accessCard);
            // find
//            Employee employee1 = entityManager.find(Employee.class, 2L);
//            AccessCard accessCard1 = entityManager.find(AccessCard.class, 1L);
//
//            accessCard1.setEmployee(employee1);
//            // update
//            entityManager.merge(accessCard1);

          //  sampleDataEmployee().forEach(entityManager::persist);


            transaction.commit();
        }
        JPAUtil.shutDown();


    }

    static List<Employee> sampleDataEmployee(){
        var dep =  new Department();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Doe", Gender.MALE, "john.doe@example.com", 60000.00, LocalDate.of(2020, 1, 1)));
        employees.add(new Employee("Jane", "Smith", Gender.FEMALE, "jane.smith@example.com", 65000.00, LocalDate.of(2019, 3, 15)));
        employees.add(new Employee("Mike", "Brown", Gender.MALE, "mike.brown@example.com", 70000.00, LocalDate.of(2021, 6, 20)));
        employees.add(new Employee("Emily", "Davis", Gender.FEMALE, "emily.davis@example.com", 72000.00, LocalDate.of(2018, 11, 30)));
        employees.add(new Employee("James", "Wilson", Gender.MALE, "james.wilson@example.com", 68000.00, LocalDate.of(2020, 5, 25)));
        employees.add(new Employee("Jessica", "Martinez", Gender.FEMALE, "jessica.martinez@example.com", 71000.00, LocalDate.of(2017, 7, 10)));
        employees.add(new Employee("Chris", "Johnson", Gender.MALE, "chris.johnson@example.com", 69000.00, LocalDate.of(2021, 8, 5)));
        employees.add(new Employee("Laura", "Garcia", Gender.FEMALE, "laura.garcia@example.com", 73000.00, LocalDate.of(2019, 9, 1)));
        employees.add(new Employee("David", "Clark", Gender.MALE, "david.clark@example.com", 64000.00, LocalDate.of(2020, 12, 15)));
        employees.add(new Employee("Sophia", "Rodriguez", Gender.FEMALE, "sophia.rodriguez@example.com", 75000.00, LocalDate.of(2018, 4, 20)));

        employees.forEach(employee -> {
            dep.setDepartmentId((long)(random()* 5)+6);
            employee.setDepartment(dep);
        });

        return employees;

    }

    static List<Department> sampleDataDepartment() {
        return List.of(
                new Department("Sales"),
                new Department("Human Resources"),
                new Department("Information Technology"),
                new Department("Marketing"),
                new Department("Finance"));

    }
}
