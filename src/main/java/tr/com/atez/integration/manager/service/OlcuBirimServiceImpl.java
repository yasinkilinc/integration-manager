package tr.com.atez.integration.manager.service;

import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.entity.OlcuBirim;
import tr.com.atez.integration.manager.repository.OlcuBirimJPARepository;
import tr.com.atez.integration.manager.service.base.BaseSecServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OlcuBirimServiceImpl extends BaseSecServiceImpl<OlcuBirim> implements OlcuBirimService {

    private final OlcuBirimJPARepository olcuBirimJPARepository;

    public OlcuBirimServiceImpl(OlcuBirimJPARepository olcuBirimJPARepository) {
        super(olcuBirimJPARepository);
        this.olcuBirimJPARepository = olcuBirimJPARepository;
    }

    @Override
    public Map<String, OlcuBirim> findAllByCms() {
        List<OlcuBirim> olcuBirimList = olcuBirimJPARepository.findAllByCmsIsNotNull();
        Map<String, OlcuBirim> result = new HashMap<>();
        olcuBirimList.forEach( olcuBirim -> result.put(olcuBirim.getCms(), olcuBirim));
        return result;
    }
}
