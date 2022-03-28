package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.entity.BeyannameVeriAktarma;
import tr.com.atez.integration.manager.service.base.BaseSecService;

import java.util.List;

public interface BeyannameVeriAktarmaService extends BaseSecService<BeyannameVeriAktarma> {
    BeyannameVeriAktarma findBybeyannameVeriAktarmaId(String beyannameId);
    List<BeyannameVeriAktarma> findByMusRefNo2(String musRefNo2);
}
