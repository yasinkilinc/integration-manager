package tr.com.atez.integration.manager.service.base;

import tr.com.atez.integration.manager.entity.base.AbstractBaseIdEntity;
import tr.com.atez.integration.manager.repository.base.BaseJPARepository;

import java.util.List;

public abstract class BaseServiceImpl <T extends AbstractBaseIdEntity> implements BaseService<T>{

    private final BaseJPARepository baseJPARepository;

    public BaseServiceImpl(BaseJPARepository baseJPARepository) {
        this.baseJPARepository = baseJPARepository;
    }

    @Override
    public T findById(String id) {
        return (T) baseJPARepository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return baseJPARepository.findAll();
    }

    @Override
    public T save(T entity) {
        return (T) baseJPARepository.save(entity);
    }

    @Override
    public T saveAndFlush(T entity) {
        return (T) baseJPARepository.saveAndFlush(entity);
    }

    @Override
    public void saveAll(Iterable<T> entities) {
        baseJPARepository.save(entities);
    }

    @Override
    public void delete(T entity) {
        baseJPARepository.delete(entity.getId());
    }

    @Override
    public void deleteById(Long id) {
        baseJPARepository.deleteById(id);
    }

}
