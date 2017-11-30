package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by limengnan on 2017/11/30.
 */

public class BaseDaoImpl<T> implements BaseDao<T> {

    private BaseDao<T> dao;
    @Autowired
    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }

    @Autowired
    private SessionFactory sessionFactory;


    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }


    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void persist(Object entity) {

    }

    @Override
    public void save(Object entity) {
        getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Object entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void flush() {

    }
}
