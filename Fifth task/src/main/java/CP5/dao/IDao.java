package CP5.dao;

import java.util.List;

public interface IDao<T> {
    void create(T t);
    void update(T t);
    void delete(T t);

    List<T> findAll();
}
