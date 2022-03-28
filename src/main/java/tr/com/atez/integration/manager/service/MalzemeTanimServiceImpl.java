package tr.com.atez.integration.manager.service;

import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.entity.MalzemeTanim;
import tr.com.atez.integration.manager.repository.MalzemeTanimJPARepository;
import tr.com.atez.integration.manager.service.base.BaseSecServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MalzemeTanimServiceImpl extends BaseSecServiceImpl<MalzemeTanim> implements MalzemeTanimService {

    private final MalzemeTanimJPARepository malzemeTanimJPARepository;

    public MalzemeTanimServiceImpl(MalzemeTanimJPARepository malzemeTanimJPARepository) {
        super(malzemeTanimJPARepository);
        this.malzemeTanimJPARepository = malzemeTanimJPARepository;
    }

    @Override
    public Map<String, MalzemeTanim> findAllByFirmaId(String firmaId) {
        List<MalzemeTanim> allByFirmaId = malzemeTanimJPARepository.findAllByFirmaId(firmaId);
        Map<String, MalzemeTanim> result = new HashMap<>();
        allByFirmaId.forEach( malzemeTanim -> {
            result.put(malzemeTanim.getKod() , malzemeTanim);
        });
        return result;
    }
}
