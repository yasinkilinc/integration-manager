package tr.com.atez.integration.manager.repository;

import tr.com.atez.integration.manager.entity.Manifesto;
import tr.com.atez.integration.manager.repository.base.BaseJPARepository;

import java.util.List;

public interface ManifestoJPARepository extends BaseJPARepository<Manifesto, String> {

    List<Manifesto> findByStatusOrderByCreateDate(Manifesto.Status status);

}
