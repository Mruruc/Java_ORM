package com.mruruc.repository;

import com.mruruc.model.Employee;
import com.mruruc.model.Projection;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findFirstByOrderByEmailAsc();
    Employee findTopByOrderByHireDateDesc();
    List<Employee> findFirst2BySalaryIsGreaterThan(double salary, Sort sort);

    Streamable<Employee> findEmployeeByEmailIsLikeIgnoreCase(String email);

    List<Projection.EmployeeSummary> findByHireDateAfter(LocalDate hireDate);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = :newEmail WHERE e.email = :oldEmail")
    int updateEmail(@Param("oldEmail") String oldEmail, String newEmail);
}
