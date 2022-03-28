package tr.com.atez.integration.manager.service;

import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.entity.Beyanname;
import tr.com.atez.integration.manager.repository.BeyannameJPARepository;
import tr.com.atez.integration.manager.service.base.BaseSecServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BeyannameServiceImpl extends BaseSecServiceImpl<Beyanname> implements BeyannameService {

    @PersistenceContext
    private EntityManager entityManager;

    private final BeyannameJPARepository beyannameJPARepository;

    public BeyannameServiceImpl(BeyannameJPARepository beyannameJPARepository) {
        super(beyannameJPARepository);
        this.beyannameJPARepository = beyannameJPARepository;
    }

    @Override
    public Beyanname findByBeyannameId(String beyannameId) {
        return beyannameJPARepository.findByBeyannameId(beyannameId);
    }

    @Override
    public Beyanname findFirstByDepartmanIdOrderByReferansNoDesc(String depertmanId) {
        return beyannameJPARepository.findFirstByDepartmanIdOrderByReferansNoDesc(depertmanId);
    }

    @Override
    public void detachBeyanname(Beyanname beyanname) {
        entityManager.detach(beyanname);
    }

}
