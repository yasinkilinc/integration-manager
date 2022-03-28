package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.entity.MalzemeTanim;
import tr.com.atez.integration.manager.service.base.BaseSecService;

import java.util.Map;

public interface MalzemeTanimService extends BaseSecService<MalzemeTanim> {

    Map<String ,MalzemeTanim> findAllByFirmaId(String firmaId);

}
