package com.mruruc.service;

import com.mruruc.model.Employee;
import com.mruruc.repository.CustomRepository;
import com.mruruc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CustomRepository customRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, CustomRepository customRepository) {
        this.employeeRepository = employeeRepository;
        this.customRepository = customRepository;
    }

    public List<Employee> findTwoEmployeeWhereIsTheirSalaryIsGreaterThan(double salaryCondition){
        return employeeRepository.findFirst2BySalaryIsGreaterThan(salaryCondition, Sort.by(Sort.Order.desc("salary")));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    public List<Employee> findAllEmployee() {
        return customRepository.findAll();
    }

    public void deleteEmployeeByEmail(String email) {
        customRepository.deleteByEmail(email);
    }
}
