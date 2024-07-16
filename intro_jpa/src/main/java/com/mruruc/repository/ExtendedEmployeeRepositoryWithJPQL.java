package com.mruruc.repository;

import com.mruruc.exceptions.DataAccessException;
import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class ExtendedEmployeeRepositoryWithJPQL extends GenericRepository<Employee, Long> {
    public ExtendedEmployeeRepositoryWithJPQL() {
        super(Employee.class);
    }

    public Optional<Employee> findEmployeeByEmail(String email) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            TypedQuery<Employee> query = entityManager.createQuery("FROM Employee e WHERE e.email = :email", Employee.class);
            query.setParameter("email", email);
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        } catch (Exception exception) {
            throw new DataAccessException("While Accessing DB exception occurred", exception);
        }
    }

    public List<Employee> findEmployeeBySalaryRangeANDSortBySalaryDESC(Double min, Double max) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            TypedQuery<Employee> query =
                    entityManager.createQuery("FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary ORDER BY e.salary DESC ", Employee.class);
            query.setParameter("minSalary", min);
            query.setParameter("maxSalary", max);
            return query.getResultList();
        }
    }

    public List<Employee> findEmployeeBasedOnSearchParams(String searchParam) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            TypedQuery<Employee> query = entityManager.createQuery(
                    " FROM Employee e WHERE e.firstName LIKE :searchParam OR e.lastName LIKE  :searchParam ",
                    Employee.class
            );
            query.setParameter("searchParam", "%" + searchParam + "%");
            // query.setParameter("searchParam2","%" + searchParam + "%");
            return query.getResultList();
        }
    }
}








