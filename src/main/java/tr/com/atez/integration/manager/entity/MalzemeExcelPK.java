package tr.com.atez.integration.manager.entity;

import javax.persistence.Column;
import java.io.Serializable;

import static tr.com.atez.integration.manager.constant.ApplicationConstants.FIRMA_KODU;
import static tr.com.atez.integration.manager.constant.ApplicationConstants.KULLANICI_KOD;

public class MalzemeExcelPK implements Serializable {

    @Column(name = FIRMA_KODU)
    protected String firmaKodu;

    @Column(name = KULLANICI_KOD)
    protected String kullaniciKod;

}
