package com.mruruc;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import com.mruruc.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws IllegalAccessException {

        EmployeeRepository employeeRepository = new EmployeeRepository();

        // sample data

//        List<Employee> employees = List.of(
//                new Employee("John", "Doe", "john_doe@gmail.com", 3650.0, LocalDate.of(2023, 7, 1)),
//                new Employee("Jane", "Smith", "jane_smith@gmail.com", 4000.0, LocalDate.of(2022, 6, 15)),
//                new Employee("Michael", "Johnson", "michael_johnson@gmail.com", 4500.0, LocalDate.of(2021, 5, 10)),
//                new Employee("Emily", "Davis", "emily_davis@gmail.com", 4200.0, LocalDate.of(2020, 4, 20)),
//                new Employee("David", "Miller", "david_miller@gmail.com", 3850.0, LocalDate.of(2019, 3, 25)),
//                new Employee("Sarah", "Brown", "sarah_brown@gmail.com", 3900.0, LocalDate.of(2018, 2, 28)),
//                new Employee("Robert", "Jones", "robert_jones@gmail.com", 4100.0, LocalDate.of(2017, 1, 15)),
//                new Employee("Laura", "Garcia", "laura_garcia@gmail.com", 3950.0, LocalDate.of(2016, 12, 5)),
//                new Employee("James", "Martinez", "james_martinez@gmail.com", 4300.0, LocalDate.of(2015, 11, 18)),
//                new Employee("Linda", "Hernandez", "linda_hernandez@gmail.com", 4600.0, LocalDate.of(2014, 10, 22)));


        //employees.forEach(employeeRepository::save);

//        Employee employee = employeeRepository.findById(2L).get();
//        employee.setSalary(10000.00);
//        employeeRepository.update(employee);

//        Employee employee =
//                new Employee("John", "Doe", "john_doe@gmail.com", 3650.0, LocalDate.of(2023, 7, 1));
//        employee.setEmail("johny_second_email@com");
//        employee.setEmployeeId(3L);
//        employeeRepository.update(employee);

      //  employeeRepository.delete(2L);


//        employeeRepository.findAll()
//                        .forEach(System.out::println);


//        employee.setSalary(6000.00);
//        employeeRepository.update(35L,employee);
//        System.out.println(employee);


//        Employee employee =
//                new Employee("Linda", "Hernandez", "linda21_hernandez@gmail.com", 4600.0, LocalDate.of(2014, 10, 22));
//        employee.setEmployeeId(2L);
//        employee.setSalary(7000.00);
//
//        try(EntityManager entityManager = JPAUtil.getEmf().createEntityManager()){
//            EntityTransaction transaction = entityManager.getTransaction();
//            transaction.begin();
//
//            // entityManager.persist(employee);
//            entityManager.merge(employee);
//
//            transaction.commit();
//        }
        JPAUtil.shutDown();

    }
}
