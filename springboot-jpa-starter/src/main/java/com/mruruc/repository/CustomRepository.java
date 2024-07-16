package com.mruruc.repository;

import com.mruruc.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomRepository {
//    @PersistenceUnit
//	private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public CustomRepository() {
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return entityManager.createQuery("FROM Employee e join fetch e.department ", Employee.class).getResultList();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByEmail(String email) {
        entityManager
                .createQuery("DELETE FROM Employee e WHERE e.email LIKE :email")
                .setParameter("email", email)
                .executeUpdate();
    }
}
