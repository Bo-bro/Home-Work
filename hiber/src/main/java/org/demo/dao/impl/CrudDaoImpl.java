package org.demo.dao.impl;

import org.demo.dao.api.CrudDao;

import java.util.List;

public class CrudDaoImpl<T, Integer> implements CrudDao <T, Integer>{

    @Override
    public List<T> getAll() {
        return null;
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
