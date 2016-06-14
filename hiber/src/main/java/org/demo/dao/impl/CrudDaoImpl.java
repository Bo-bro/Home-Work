package org.demo.dao.impl;

import org.demo.dao.api.CrudDao;
import org.demo.helpers.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CrudDaoImpl<T, Integer> implements CrudDao <T, Integer>{
T t;
    @Override
    public List<T> getAll() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<T> entityList = (List<T>) session.createCriteria(t.getClass()).list();
        //or T.class

        return entityList;
    }




    @Override
    public void create(T t) {

    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
