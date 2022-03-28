package tr.com.atez.integration.manager.repository;

import tr.com.atez.integration.manager.entity.BeyannameSurec;
import tr.com.atez.integration.manager.repository.base.BaseJPARepository;

import java.util.UUID;

public interface BeyannameSurecJPARepository extends BaseJPARepository<BeyannameSurec, String> {

    BeyannameSurec findByBeyannameIdAndSurecTanimId(UUID beyannameId, UUID surecTanimId);

}
