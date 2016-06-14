package org.demo.dao.api;

import java.util.List;

public interface CrudDao<T, K> {
    List<T> getAll();
    void create(T t);
    T update(T t);
    void delete(K id);
    T get(K id);


}
