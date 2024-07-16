package com.mruruc;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import com.mruruc.repository.ExtendedEmployeeRepositoryWithJPQL;

import java.time.LocalDate;
import java.util.List;

public class TestingJPQL {
    public static void main(String[] args) {

        var repo = new ExtendedEmployeeRepositoryWithJPQL();

//        System.out.println(
//                repo.findEmployeeByEmail("johny_second_email@com21")
//        );


//        repo.findEmployeeBySalaryRangeANDSortBySalaryDESC(1000.0, 2500.0)
//                .forEach(e-> System.out.println(e.getSalary()));

//        repo.findEmployeeBasedOnSearchParams("th")
//                        .forEach(e-> System.out.println(e.getFirstName()));

        JPAUtil.shutDown();
    }



    static List<Employee> sampleData() {
        List<Employee> employees =
                List.of(
                        new Employee("John", "Doe", "john_doe@gmail.com", 3650.0, LocalDate.of(2023, 7, 1)),
                        new Employee("Jane", "Smith", "jane_smith@gmail.com", 4000.0, LocalDate.of(2022, 6, 15)),
                        new Employee("Michael", "Johnson", "michael_johnson@gmail.com", 4500.0, LocalDate.of(2021, 5, 10)),
                        new Employee("Emily", "Davis", "emily_davis@gmail.com", 4200.0, LocalDate.of(2020, 4, 20)),
                        new Employee("David", "Miller", "david_miller@gmail.com", 3850.0, LocalDate.of(2019, 3, 25)),
                        new Employee("Sarah", "Brown", "sarah_brown@gmail.com", 3900.0, LocalDate.of(2018, 2, 28)),
                        new Employee("Robert", "Jones", "robert_jones@gmail.com", 4100.0, LocalDate.of(2017, 1, 15)),
                        new Employee("Laura", "Garcia", "laura_garcia@gmail.com", 3950.0, LocalDate.of(2016, 12, 5)),
                        new Employee("James", "Martinez", "james_martinez@gmail.com", 4300.0, LocalDate.of(2015, 11, 18)),
                        new Employee("Linda", "Hernandez", "linda_hernandez@gmail.com", 4600.0, LocalDate.of(2014, 10, 22)));
        return employees;
    }
}


