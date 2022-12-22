package info.uaic.ro.project.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Service<T> {
    T findById(int id);
    List<T> findAll();
    void create(T t);
    void update(T t);
    void remove(T t);
}
