package org.migatotech.dal;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    void add(T entity);
    void modify(T entity);
    public void remove(T entity);

    Optional<List<T>> getAll();
    Optional<T> getById(int id);
}
