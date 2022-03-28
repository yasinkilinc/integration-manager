package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.entity.BeyannameSurec;
import tr.com.atez.integration.manager.service.base.BaseSecService;

import java.util.UUID;

public interface BeyannameSurecService extends BaseSecService<BeyannameSurec> {

    BeyannameSurec findByBeyannameIdAndSurecTanimId(UUID beyannameId, UUID surecTanimId);

}
