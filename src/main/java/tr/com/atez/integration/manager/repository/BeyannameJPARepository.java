package tr.com.atez.integration.manager.repository;

import tr.com.atez.integration.manager.entity.Beyanname;
import tr.com.atez.integration.manager.repository.base.BaseJPARepository;

public interface BeyannameJPARepository extends BaseJPARepository<Beyanname, String> {

    Beyanname findFirstByDepartmanIdOrderByReferansNoDesc(String departmanId);

    Beyanname findByBeyannameId(String firmaId);
}
