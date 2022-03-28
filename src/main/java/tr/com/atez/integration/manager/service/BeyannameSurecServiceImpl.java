package tr.com.atez.integration.manager.service;

import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.entity.BeyannameSurec;
import tr.com.atez.integration.manager.repository.BeyannameSurecJPARepository;
import tr.com.atez.integration.manager.service.base.BaseSecServiceImpl;

import java.util.UUID;

@Service
public class BeyannameSurecServiceImpl extends BaseSecServiceImpl<BeyannameSurec> implements BeyannameSurecService {

    private final BeyannameSurecJPARepository beyannameSurecJPARepository;

    public BeyannameSurecServiceImpl(BeyannameSurecJPARepository beyannameSurecJPARepository) {
        super(beyannameSurecJPARepository);
        this.beyannameSurecJPARepository = beyannameSurecJPARepository;
    }

    @Override
    public BeyannameSurec findByBeyannameIdAndSurecTanimId(UUID beyannameId, UUID surecTanimId) {
        return beyannameSurecJPARepository.findByBeyannameIdAndSurecTanimId(beyannameId, surecTanimId);
    }
}
