package com.mruruc.repository;

import com.mruruc.exceptions.IdFieldNotFoundException;
import com.mruruc.jpa_util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Id;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class GenericRepository<T, ID> {
    private final Class<T> entityClazz;

    public GenericRepository(final Class<T> entityClazz) {
        this.entityClazz = entityClazz;
    }

    public T save(T entity) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();

            if (isNew(entity)) entityManager.persist(entity);
            else entityManager.merge(entity);

            transaction.commit();
            return entity;
        } catch (Exception exception) {
            if (transaction != null && transaction.isActive()) transaction.rollback();
            throw exception;
        }
    }

    public Optional<T> findById(ID id) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            return Optional.ofNullable(entityManager.find(entityClazz, id));
        }
    }

    public List<T> findAll() {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            return entityManager.createQuery("FROM " + entityClazz.getSimpleName(), entityClazz).getResultList();
        }
    }

    public void delete(ID id) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Optional.ofNullable(entityManager.find(entityClazz, id))
                    .ifPresentOrElse(entityManager::remove, () -> {
                        throw new EntityNotFoundException("Entity Not Found");
                    });

            //  .orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
//            entityManager.remove(entityFound);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw exception;
        }
    }

    private boolean isNew(T entity) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            ID entityId = this.getEntityId(entity);
            return entityId == null || entityManager.find(entityClazz, entityId) == null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to get ID from entity.", e);
        }
    }

    private ID getEntityId(T entity) throws IllegalAccessException {
        Field idField = getEntityIdField();
        idField.setAccessible(true);
        return (ID) idField.get(entity);
    }

    private Field getEntityIdField() {
        for (Field idField : entityClazz.getDeclaredFields())
            if (idField.isAnnotationPresent(Id.class)) return idField;
        throw new IdFieldNotFoundException("Id Field Not Found");
    }
}