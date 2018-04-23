package com.limn.update.server.dao;

/**
 * Created by limengnan on 2017/11/30.
 */
import java.util.List;


public interface BaseDao<T>{

    List<T> findAll();

    void persist(T entity);

    void save(T entity);

    void saveOrUpdate(T entity);

    void flush();

    void update(T entity);

    void merge(T entity);
    void mergeAs(Object entity);
    void saveAs(T entity);

    void updateAs(T entity);

    Object uniqueResult(String hql);
    List<Object> listResult(String hql);
}