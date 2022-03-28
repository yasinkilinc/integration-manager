package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.entity.Beyanname;
import tr.com.atez.integration.manager.service.base.BaseSecService;

public interface BeyannameService extends BaseSecService<Beyanname> {
    Beyanname findByBeyannameId(String beyannameId);
    Beyanname findFirstByDepartmanIdOrderByReferansNoDesc(String depertmanId);
    void detachBeyanname(Beyanname beyanname);

}
