package tr.com.atez.integration.manager.service.base;

import tr.com.atez.integration.manager.entity.base.AbstractBaseIdEntity;

import java.util.List;

public interface BaseService <T extends AbstractBaseIdEntity> {

    T findById(String primaryKey);
    List<T> findAll();
    T save(T entity);
    T saveAndFlush(T entity);
    void saveAll(Iterable<T> entities);
    void delete(T entity);
    void deleteById(Long id);

}
