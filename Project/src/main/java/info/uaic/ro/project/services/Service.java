package info.uaic.ro.project.services;
import java.util.List;

public interface Service<T> {
    T findById(int id);
    List<T> findAll();
    void create(T t);
    void update(T t);
    void remove(T t);
}
