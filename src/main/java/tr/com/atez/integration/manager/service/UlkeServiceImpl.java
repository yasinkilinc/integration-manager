package tr.com.atez.integration.manager.service;

import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.entity.Ulke;
import tr.com.atez.integration.manager.repository.UlkeJPARepository;
import tr.com.atez.integration.manager.service.base.BaseSecServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UlkeServiceImpl extends BaseSecServiceImpl<Ulke> implements UlkeService {

    private final UlkeJPARepository ulkeJPARepository;

    public UlkeServiceImpl(UlkeJPARepository ulkeJPARepository) {
        super(ulkeJPARepository);
        this.ulkeJPARepository = ulkeJPARepository;
    }


    @Override
    public Map<String, Ulke> findAllByKisaAd() {
        List<Ulke> ulkeList = ulkeJPARepository.findAllByKisaAdIsNotNull();
        Map<String, Ulke> result = new HashMap<>();
        ulkeList.forEach( ulke -> {
                result.put(ulke.getKisaAd(), ulke);
        } );
        return result;
    }
}
