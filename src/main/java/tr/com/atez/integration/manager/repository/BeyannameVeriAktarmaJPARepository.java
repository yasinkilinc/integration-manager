package tr.com.atez.integration.manager.repository;

import tr.com.atez.integration.manager.entity.BeyannameVeriAktarma;
import tr.com.atez.integration.manager.repository.base.BaseJPARepository;

import java.util.List;

public interface BeyannameVeriAktarmaJPARepository extends BaseJPARepository<BeyannameVeriAktarma, String> {

    BeyannameVeriAktarma findBybeyannameVeriAktarmaId(String beyannameVeriAktarmaid);

    List<BeyannameVeriAktarma> findBymusRefNo2(String musRefNo2);

}
