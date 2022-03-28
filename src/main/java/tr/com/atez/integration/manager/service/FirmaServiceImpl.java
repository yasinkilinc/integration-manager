package tr.com.atez.integration.manager.service;

import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.entity.Firma;
import tr.com.atez.integration.manager.repository.FirmaJPARepository;

@Service
public class FirmaServiceImpl implements FirmaService {

    private final FirmaJPARepository firmaJPARepository;

    public FirmaServiceImpl(FirmaJPARepository firmaJPARepository) {
        this.firmaJPARepository = firmaJPARepository;
    }

    @Override
    public Firma findByFirmaId(String firmaId) {
        return firmaJPARepository.findByfirmaId(firmaId);
    }
}
