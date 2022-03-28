package tr.com.atez.integration.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.atez.integration.manager.entity.MalzemeExcel;

import java.io.Serializable;

public interface MalzemeExcelJPARepository <T, ID extends Serializable> extends JpaRepository<MalzemeExcel, Long> {
    MalzemeExcel findByFirmaKoduAndKullaniciKod(String firmaKodu, String kullaniciKod);
}
