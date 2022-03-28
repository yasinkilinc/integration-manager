package tr.com.atez.integration.manager.repository;

import tr.com.atez.integration.manager.entity.OlcuBirim;
import tr.com.atez.integration.manager.repository.base.BaseJPARepository;

import java.util.List;

public interface OlcuBirimJPARepository extends BaseJPARepository<OlcuBirim, String> {

    List<OlcuBirim> findAllByCmsIsNotNull();

}
