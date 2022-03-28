package tr.com.atez.integration.manager.repository;

import tr.com.atez.integration.manager.entity.Ulke;
import tr.com.atez.integration.manager.repository.base.BaseJPARepository;

import java.util.List;

public interface UlkeJPARepository extends BaseJPARepository<Ulke, String> {

    List<Ulke> findAllByKisaAdIsNotNull();

}
