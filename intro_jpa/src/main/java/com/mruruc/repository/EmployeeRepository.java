package com.mruruc.repository;

import com.mruruc.model.Employee;

public class EmployeeRepository extends GenericRepository<Employee,Long>{
    public EmployeeRepository() {
        super(Employee.class);
    }
}
