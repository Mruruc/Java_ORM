package com.mruruc.repository;

import com.mruruc.util.HibernateUtil;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CRUDImpl<T, ID> implements CRUD<T, ID> {
    private Class<T> type;

    public CRUDImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User ", type).list();
        }
    }

    @Override
    public T save(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw exception;
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(type, id));
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public void delete(ID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T entity = session.get(type, id);
            session.remove(entity);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw exception;
        }
    }


    @Override
    public T update(ID id, T entity) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.evict(
                    Optional.ofNullable(session.find(type, id))
                            .orElseThrow(() -> new EntityNotFoundException("Entity Not Found"))
            );

            session.update(entity);
            transaction.commit();
            return entity;
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw exception;
        }

    }
}











