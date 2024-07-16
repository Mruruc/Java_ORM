package com.mruruc;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import com.mruruc.repository.ExtendedEmployeeRepositoryWithCriteriaAPI;

import java.util.List;

public class TestingCriteriaQueries {
    public static void main(String[] args) {

        var repo = new ExtendedEmployeeRepositoryWithCriteriaAPI();

//        List<Employee> allEmployees = repo.findAllEmployees();

//        repo.findEmployeesWithSalaryGreaterThanAverage()
//                .forEach(System.out::println);

        repo.findEmployeeBasedOnSearchParams("l")
                        .forEach(employee ->
                                System.out.println(
                                        employee.getFirstName() + " " + employee.getLastName() + " " + employee.getSalary()
                                )
                        );
        JPAUtil.shutDown();
    }
}
