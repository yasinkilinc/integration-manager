package tr.com.atez.integration.manager.service;

import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.entity.BeyannameVeriAktarma;
import tr.com.atez.integration.manager.repository.BeyannameVeriAktarmaJPARepository;
import tr.com.atez.integration.manager.service.base.BaseSecServiceImpl;

import java.util.List;

@Service
public class BeyannameVeriAktarmaServiceImpl extends BaseSecServiceImpl<BeyannameVeriAktarma> implements BeyannameVeriAktarmaService  {

    private final BeyannameVeriAktarmaJPARepository beyannameVeriAktarmaJPARepository;

    public BeyannameVeriAktarmaServiceImpl(BeyannameVeriAktarmaJPARepository beyannameVeriAktarmaJPARepository) {
        super(beyannameVeriAktarmaJPARepository);
        this.beyannameVeriAktarmaJPARepository = beyannameVeriAktarmaJPARepository;
    }

    @Override
    public BeyannameVeriAktarma findBybeyannameVeriAktarmaId(String beyannameId) {
        return beyannameVeriAktarmaJPARepository.findBybeyannameVeriAktarmaId(beyannameId);
    }

    @Override
    public List<BeyannameVeriAktarma> findByMusRefNo2(String musRefNo2) {
        return beyannameVeriAktarmaJPARepository.findBymusRefNo2(musRefNo2);
    }

}
