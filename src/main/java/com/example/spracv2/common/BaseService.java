package com.example.spracv2.common;
import java.util.List;
import java.util.UUID;

public interface BaseService<T, ID> {

    T create(T entity);

    T getById(ID id);

    List<T> getAll();

    T update(T entity);

    void delete(ID id);

}

