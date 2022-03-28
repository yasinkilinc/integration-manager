package tr.com.atez.integration.manager.service;

import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.config.BusinessConfig;
import tr.com.atez.integration.manager.entity.MalzemeExcel;
import tr.com.atez.integration.manager.repository.MalzemeExcelJPARepository;

@Service
public class MalzemeExcelServiceImpl implements MalzemeExcelService {

    private final MalzemeExcelJPARepository malzemeExcelJPARepository;

    public MalzemeExcelServiceImpl(MalzemeExcelJPARepository malzemeExcelJPARepository,
                                   BusinessConfig businessConfig) {
        this.malzemeExcelJPARepository = malzemeExcelJPARepository;
    }

    @Override
    public MalzemeExcel findMalzemeExcel(String firmKod, String kullaniciKod) {
        return malzemeExcelJPARepository.findByFirmaKoduAndKullaniciKod(firmKod, kullaniciKod);
    }
}
