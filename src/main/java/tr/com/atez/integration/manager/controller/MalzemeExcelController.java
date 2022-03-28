package tr.com.atez.integration.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tr.com.atez.integration.manager.config.BusinessConfig;
import tr.com.atez.integration.manager.entity.MalzemeExcel;
import tr.com.atez.integration.manager.service.MalzemeExcelService;

import static tr.com.atez.integration.manager.constant.ControllerMappingConstants.MALZEME_EXCEL_CONTROLLER;

@RestController
public class MalzemeExcelController {
    private final MalzemeExcelService malzemeExcelService;
    private final BusinessConfig businessConfig;

    public MalzemeExcelController(MalzemeExcelService malzemeExcelService, BusinessConfig businessConfig) {
        this.malzemeExcelService = malzemeExcelService;
        this.businessConfig = businessConfig;
    }

    @RequestMapping(value = MALZEME_EXCEL_CONTROLLER, method = RequestMethod.GET)
    public MalzemeExcel findMalzemeExcel(){
        return malzemeExcelService.findMalzemeExcel(businessConfig.getFirmaKod(), businessConfig.getKullaniciKod());
    }
}
