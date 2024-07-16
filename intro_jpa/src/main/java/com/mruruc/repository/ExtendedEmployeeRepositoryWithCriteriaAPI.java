package com.mruruc.repository;

import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.List;

public class ExtendedEmployeeRepositoryWithCriteriaAPI extends GenericRepository<Employee, Long> {
    public ExtendedEmployeeRepositoryWithCriteriaAPI() {
        super(Employee.class);
    }


    public List<Employee> findAllEmployees() {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            criteriaQuery
                    .select(criteriaQuery.from(Employee.class));
            return entityManager.createQuery(criteriaQuery).getResultList();
        }
    }

    public List<Employee> findEmployeeByFirstName(String firstName) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery
                    .select(root)
                    .where(criteriaBuilder.equal(root.get("firstName"), firstName))
                    .orderBy(criteriaBuilder.desc(root.get("salary")));

            return entityManager.createQuery(criteriaQuery).getResultList();
        }
    }

    /**
     * sql
     * SELECT * FROM employees
     * where salary >
     * (SELECT AVG(salary) from employees);
     */
    public List<Employee> findEmployeesWithSalaryGreaterThanAverage() {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            // criteria builder used to construct criteria query
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            // criteriaQuery is used to define the query that will return specified entity.
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            // defines root of the query.
            Root<Employee> root = criteriaQuery.from(Employee.class);

            // a subquery that will return a specified type.
            Subquery<Double> subquery = criteriaQuery.subquery(Double.class);
            Root<Employee> subRoot = subquery.from(Employee.class);


            criteriaQuery
                    .multiselect(root.get("firstName"), root.get("salary"))
                    .where(criteriaBuilder.greaterThan(root.get("salary"),
                            subquery.select(criteriaBuilder.avg(subRoot.get("salary"))))
                    );

            return entityManager.createQuery(criteriaQuery).getResultList();
        }
    }


    public List<Employee> findEmployeeBasedOnSearchParams(String searchParam) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

            Root<Employee> root = criteriaQuery.from(Employee.class);

            String pattern = "%" + searchParam + "%";
            criteriaQuery
                    .multiselect(root.get("firstName"), root.get("lastName"), root.get("email"))
                    .where(
                            criteriaBuilder.or(
                                    criteriaBuilder.like(root.get("firstName"), pattern),
                                    criteriaBuilder.like(root.get("lastName"), pattern)
                            )
                    );
            return entityManager.createQuery(criteriaQuery).getResultList();
        }
    }


}
