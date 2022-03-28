package tr.com.atez.integration.manager.service.base;

import java.io.Serializable;
import java.util.List;

public interface BaseSecService<T extends Serializable> {

    T findById(String primaryKey);
    List<T> findAll();
    T save(T entity);
    T saveAndFlush(T entity);
    void saveAll(Iterable<T> entities);
    void delete(T entity);

}
