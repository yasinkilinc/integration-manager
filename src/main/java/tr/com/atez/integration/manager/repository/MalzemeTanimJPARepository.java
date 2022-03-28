package tr.com.atez.integration.manager.repository;

import tr.com.atez.integration.manager.entity.MalzemeTanim;
import tr.com.atez.integration.manager.repository.base.BaseJPARepository;

import java.util.List;

public interface MalzemeTanimJPARepository extends BaseJPARepository<MalzemeTanim, String> {

    List<MalzemeTanim> findAllByFirmaId(String firmaId);

}
