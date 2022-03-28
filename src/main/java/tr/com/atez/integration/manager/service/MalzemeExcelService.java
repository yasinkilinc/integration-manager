package tr.com.atez.integration.manager.service;

import tr.com.atez.integration.manager.entity.MalzemeExcel;

public interface MalzemeExcelService {
    MalzemeExcel findMalzemeExcel(String firmKod, String kullaniciKod);

}
