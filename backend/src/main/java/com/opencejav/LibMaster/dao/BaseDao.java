package com.opencejav.LibMaster.dao;

public interface BaseDao<T> {
    T save(T t);
    T update(T t);
    T findById(Long id);
    void delete(Long id);
    Iterable<T> findAll();
}
