package application.model.dao;

import application.model.exception.MySqlException;

import java.util.List;

public interface GenericDao<T, K> {

    void save(T t) throws MySqlException;

    T getByID(K k) throws MySqlException;

    T getByName(T t) throws MySqlException;

    List<T> getAll() throws MySqlException;

    void deleteById(K id);

}
