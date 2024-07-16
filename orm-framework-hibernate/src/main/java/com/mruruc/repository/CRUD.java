package com.mruruc.repository;

import java.util.List;
import java.util.Optional;

public interface CRUD <T,ID>{
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void delete(ID id);
    T update(ID id,T entity);
}
