package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.entity.EleShopEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by limengnan on 2017/11/30.
 */


@Transactional
public class BaseDaoImpl<T> implements BaseDao<T>{

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

    protected  Session createSession(){
        return this.sessionFactory.openSession();
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
        Session newSeesion = getSession();
        Serializable id =  newSeesion.save(entity);
    }

    @Override
    public void saveOrUpdate(Object entity) {
        Session newSeesion = getSession();
        newSeesion.saveOrUpdate(entity);

    }


    @Override
    public void merge(Object entity) {
        Session newSeesion = getSession();
        newSeesion.merge(entity);

    }

    @Override
    public void mergeAs(Object entity) {
        Session session = createSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void saveAs(T entity){
        Session session = createSession();
        session.save(entity);
        session.close();
    }


    public void update(T entity) {
        Session newSeesion = getSession();
        newSeesion.update(entity);

    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void updateAs(T entity) {
        Session session = createSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Object uniqueResult(String hql){
        Session session = createSession();
        Object object = session.createQuery(hql).uniqueResult();
        session.close();
        return object;
    }

    @Override
    public List<Object> listResult(String hql){
        Session session = createSession();
        List<Object> object = session.createQuery(hql).list();
        session.close();
        return object;
    }



}
