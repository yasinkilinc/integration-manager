package tr.com.atez.integration.manager.constant;

public interface ApplicationConstants {
    // db constants
    String TABLE_PREFIX = "IM_";
    String SGM_TABLE_PREFIX = "sgm_";
    String SBR_TABLE_PREFIX = "sbr_";

    // Generic column names
    String UUID = "uuid";
    String UUID_STRATEGY = "org.hibernate.id.UUIDGenerator";
    String CREATE_DATE = "create_date";
    String UPDATE_DATE = "update_date";
    String CREATED_BY = "created_by";
    String UPDATED_BY = "updated_by";
    String VERSION = "version";
    String DELETE_DATE = "delete_date";
    String ACTIVE = "active";

    // Default Values
    Long DEFAULT_VALUE = 0L;

    // Table Names
    String CUSTOMER = TABLE_PREFIX + "CUSTOMER";
    String EVENT_DEFINITION = TABLE_PREFIX + "EVENT_DEFINITION";
    String CUSTOMER_EVENT_DEFINITION = TABLE_PREFIX + "CUSTOMER_EVENT_DEFINITION";
    String EVENT_QUEUE = TABLE_PREFIX + "EVENT_QUEUE";
    String EVENT_QUEUE_LOG = TABLE_PREFIX + "EVENT_QUEUE_LOG";
    String DATA_TYPE_DEFINITION = TABLE_PREFIX + "DATA_TYPE_DEFINITION";
    String DATA_REFERENCE_MAPPING = TABLE_PREFIX + "DATA_REFERENCE_MAPPING";
    String DATA_TYPE_ATTRIBUTE = TABLE_PREFIX + "DATA_TYPE_ATTRIBUTE";
    String DATA_REFERENCE = TABLE_PREFIX + "DATA_REFERENCE";
    String MANIFESTO = TABLE_PREFIX + "MANIFESTO";

    // SGM table names
    String MALZEME_EXCEL = SGM_TABLE_PREFIX + "MALZEMEEXCEL";
    String BEYANNAME = SGM_TABLE_PREFIX + "BEYANNAME";
    String BEYANNAME_VERI_AKTARMA = SGM_TABLE_PREFIX + "BEYANNAMEVERIAKTARMA";
    String MALZEME_TANIM = SGM_TABLE_PREFIX + "MALZEMETANIM";
    String BEYANNAME_SUREC = SGM_TABLE_PREFIX + "BEYANNAMESUREC";

    // SBR table names
    String FIRMA = SBR_TABLE_PREFIX + "FIRMA";
    String ULKE = SBR_TABLE_PREFIX + "ULKE";
    String OLCU_BIRIM = SBR_TABLE_PREFIX + "OLCUBIRIM";


    String BEYANNAME_GEN_VAL_GEN = "beyanname_gen";
    String BEYANNAME_GEN_NAME = "beyanname_gen";

    String BEYANNAME_VERI_AKTARMA_GEN_VAL_GEN = "beyanname_veri_aktarma_gen";
    String BEYANNAME_VERI_AKTARMA_GEN_NAME = "beyanname_veri_aktarma_gen";
    String BEYANNAME_SUREC_GEN_NAME = "beyanname_surec_gen";
    String BEYANNAME_SUREC_GEN_VAL_GEN = "beyanname_surec_gen";




    // Column Names
    String FIRM_ID = "FIRM_ID";
    String DESCRIPTION = "DESCRIPTION";
    String STATUS_DESCRIPTION = "STATUS_DESCRIPTION";
    String ERROR_LOG = "ERROR_LOG";
    String TYPE = "TYPE";
    String QUEUE_STATUS = "QUEUE_STATUS";
    String CUSTOMER_ID = "CUSTOMER_ID";
    String RETRY_COUNT = "RETRY_COUNT";
    String ACTION_DATE = "ACTION_DATE";
    String DOCUMENT_ID = "DOCUMENT_ID";
    String EVENT_DEFINITION_DESCRIPTION = "EVENT_DEFINITION_DESCRIPTION";
    String POSITION = "POSITION";
    String DATA_NAME = "DATA_NAME";
    String ATTRIBUTE_TYPE = "ATTRIBUTE_TYPE";
    String ATTRIBUTE_NAME = "ATTRIBUTE_NAME";
    String REFERENCE_TYPE = "REFERENCE_TYPE";
    String REFERENCE_VALUE = "REFERENCE_VALUE";
    String PARAMS = "PARAMS";
    String FILE_PATH = "FILE_PATH";
    String FILE_NAME = "FILE_NAME";
    String MANIFESTO_STATUS = "STATUS";
    String MANIFESTO_RETRY = "RETRY";

    // Malzeme Excel
    String MALZEMEEXCEL_ID = "id";
    String FIRMA_KODU = "firmakodu";
    String GTIP = "gtip";
    String FATURA_TUTARI = "faturatutari";
    String NET_AGIRLIK = "netagirlik";
    String BURUT_AGIRLIK = "burutagirlik";
    String MIKTAR = "miktar";
    String BIRIMI = "birimi";
    String MENSE_ULKE = "menseulke";
    String ULUSLARARASI_ANLASMA = "uluslararasianlasma";
    String OZELLIK = "ozellik";
    String OLCU_BIRIMI = "olcubirimi";
    String MALZEME_KODU = "malzemekodu";
    String ACIKLAMA = "aciklama";
    String KULLANICI_KOD = "kullanicikod";
    String TICARI_TANIM = "ticaritanim";
    String DIIB_SATIR_NO = "diibsatirno";
    String FATURA_NO = "faturano";
    String FATURA_TARIH = "faturatarih";
    String MUS_REF_NO1 = "musrefno1";
    String MUS_REF_NO2 = "musrefno2";
    String BOLUM = "bolum";
    String OLCU_MIKTARI = "olcumiktari";
    String YURTDISI_TUTAR = "yurtdisitutar";
    String KAP_ADET = "kapadet";
    String TUTAR2 = "tutar2";
    String ANTREPO_BEYANNAME_NO = "antrepobeyannameno";
    String ANTREPO_KALEM_SIRA_NO = "antrepokalemsirano";
    String FOB_TUTAR = "fobtutar";
    String KASA_NO = "kasano";
    String BIRIM_TUTAR = "birimtutar";
    String TEDARIKCI_KODU = "tedarikcikodu";
    String TEDARIKCI_ADI = "tedarikciadi";
    String REFERANS_NO = "referansno";
    String SEVKIYAT_NO = "sevkiyatno";
    String SEVKIYAT_HATTI = "sevkiyathatti";
    String ATR_BELGE_NO = "atrbelgeno";
    String ATR_BELGE_TARIHI = "atrbelgetarihi";
    String ON_STATU_BELGE_NO = "onstatubelgeno";
    String ON_STATU_BELGE_TARIHI = "onstatubelgetarihi";
    String YATIRIM_TESVIK_BELGE_NO = "yatirimtesvikbelgeno";
    String YATIRIM_TESVIK_TARIHI = "yatirimtesviktarihi";
    String YURTDISI_DIGER = "yurtdisidiger";
    String YURTDISI_DIGER_DOVIZI = "yurtdisidigerdovizi";
    String MENSEI_SAH_BELGE_NO = "menseisahbelgeno";
    String MENSEI_SAH_TARIHI = "menseisahtarihi";
    String TPS_BELGE_NO = "tpsbelgeno";
    String TPS_TARIHI = "tpstarihi";
    String CIKIS_ULKE_LIMAN = "cikisulkeliman";
    String GONDERICI_REFERANS = "gondericireferans";
    String KONSIMANTO_NO = "konsimantono";
    String KONTEYNER_NUMARA = "konteynernumara";
    String GEMI_ADI = "gemiadi";
    String TASIYICI_KODU = "tasiyicikodu";
    String BOSALTMA_LIMANI = "bosaltmalimani";
    String DIIB_BELGE_NO = "diibbelgeno";
    String MUAFIYET = "muafiyet";
    String DOVIZ_CINSI = "dovizcinsi";
    String TESLIM_SEKLI = "teslimsekli";
    String TASIMA_SEKLI = "tasimasekli";
    String TAHMINI_HAREKET_TARIHI = "tahminiharekettarihi";
    String TAHMINI_VARIS_TARIHI = "tahminivaristarihi";
    String TIC_YAPILAN_ULKE = "ticyapilanulke";

    // Firma
    String FIRMA_ID = "firmaid";
    String SIRKET_ID = "sirketid";
    String AD = "ad";
    String SEHIR_ID = "sehirid";
    String AKTIF = "aktif";
    String AVANS_HESAP_ID = "avanshesapid";
    String FIRMA_TIP_ID = "firmatipid";
    String GRUP_ID1 = "grupid1";
    String GRUP_ID2 = "grupid2";
    String GRUP_ID3 = "grupid3";
    String FIRMA_INT_ID = "firmaintid";
    String SEVKIYAT_NOKTA_ID = "sevkiyatnoktaid";
    String KARSI_FIRMA_ID = "karsifirmaid";
    String FIRMA_KAZANDIRAN_PERSONEL_ID = "firmakazandiranpersonelid";
    String FIYAT_BOLGE_ID = "fiyatbolgeid";
    String FIRMA_DURUM_ID = "firmadurumid";

    // Beyanname
    String BEYANNAME_ID = "beyannameid";
    String DEPARTMAN_ID = "departmanid";
    String BEYANNAME_REFERANS_NO = "referansno";
    String TESCIL_TARIHI = "tesciltarihi";
    String TESCIL_NO = "tescilno";
    String MUSTERI_ID = "musteriid";
    String GONDERICI_ID = "gondericiid";
    String MUSTERI_REFERANS_NO = "musterireferansno";
    String GONDERILEN_GUMRUK = "gonderilengumruk";
    String VARIS_GUMRUK = "varisgumruk";
    String ALICI_ID = "aliciid";
    String FATURA_FIRMA_ID = "faturafirmaid";
    String REJIM = "rejim";
    String BEYANNAME_TESLIM_SEKLI = "teslimsekli";
    String BEYANNAME_TASIMA_SEKLI = "tasimasekli";
    String BEYANNAME_CIKIS_ARAC_TIPI = "cikisaractipi";
    String BEYANNAME_CIKIS_ARAC_NO = "cikisaracno";
    String BEYANNAME_SINIR_ARAC_TIPI = "siniraractipi";
    String BEYANNAME_SINIR_ARAC_NO = "siniraracno";
    String BEYANNAME_FATURA_DOVIZ_TURU = "faturadovizturu";
    String BEYANNAME_FATURA_CIKIS_ULKE = "cikisulke";
    String BEYANNAME_FATURA_TIC_YAPILAN_ULKE = "ticyapilanulke";
    String BEYANNAME_KULLCANICI_KOD = "kullanicikod";

     // Beyanname Veri Aktarma            
     String BEYANNAME_VERI_AKTARMA_ID = "beyannameveriaktarmaid";
     String BEYANNAME_VERI_AKTARMA_BEYANNAME_ID = "beyannameid";
     String BEYANNAME_VERI_AKTARMA_GTIP = "gtip";
     String BEYANNAME_VERI_AKTARMA_FATURA_TUTARI = "faturatutari";
     String BEYANNAME_VERI_AKTARMA_NET_AGIRLIK = "netagirlik";
     String BEYANNAME_VERI_AKTARMA_BURUT_AGIRLIK = "burutagirlik";
     String BEYANNAME_VERI_AKTARMA_MIKTAR = "miktar";
     String BEYANNAME_VERI_AKTARMA_OLCU_MIKTARI = "olcumiktari";
     String BEYANNAME_VERI_AKTARMA_BIRIMI = "birimi";
     String BEYANNAME_VERI_AKTARMA_OLCU_BIRIMI = "olcubirimi";
     String BEYANNAME_VERI_AKTARMA_MENSE_ULKE = "menseulke";
     String BEYANNAME_VERI_AKTARMA_ULUSLAR_ARASI_ANLASMA = "uluslararasianlasma";
     String BEYANNAME_VERI_AKTARMA_OZELLIK = "ozellik";
     String BEYANNAME_VERI_AKTARMA_MALZEME_KODU = "malzemekodu";
     String BEYANNAME_VERI_AKTARMA_ACIKLAMA = "aciklama";
     String BEYANNAME_VERI_AKTARMA_TICARI_TANIM = "ticaritanim";
     String BEYANNAME_VERI_AKTARMA_DIIB_SATIR_NO = "diibsatirno";
     String BEYANNAME_VERI_AKTARMA_FATURA_NO = "faturano";
     String BEYANNAME_VERI_AKTARMA_FATURA_TARIH = "faturatarih";
     String BEYANNAME_VERI_AKTARMA_MUS_REF_NO1 = "musrefno1";
     String BEYANNAME_VERI_AKTARMA_MUS_REF_NO2 = "musrefno2";
     String BEYANNAME_VERI_AKTARMA_BOLUM = "bolum";
     String BEYANNAME_VERI_AKTARMA_YURTDISI_TUTAR = "yurtdisitutar";
     String BEYANNAME_VERI_AKTARMA_KAP_ADET = "kapadet";
     String BEYANNAME_VERI_AKTARMA_TUTAR2 = "tutar2";
     String BEYANNAME_VERI_AKTARMA_ANTREPO_BEYANNAME_NO = "antrepobeyannameno";
     String BEYANNAME_VERI_AKTARMA_ANTREPO_KALEM_SIRA_NO = "antrepokalemsirano";
     String BEYANNAME_VERI_AKTARMA_FOB_TUTAR = "fobtutar";
     String BEYANNAME_VERI_AKTARMA_KASA_NO = "kasano";
     String BEYANNAME_VERI_AKTARMA_BIRIM_TUTAR = "birimtutar";
     String BEYANNAME_VERI_AKTARMA_TEDARIKCI_KODU = "tedarikcikodu";
     String BEYANNAME_VERI_AKTARMA_TEDARIKCI_ADI = "tedarikciadi";
     String BEYANNAME_VERI_AKTARMA_REFERANS_NO = "referansno";
     String BEYANNAME_VERI_AKTARMA_SEVKIYAT_NO = "sevkiyatno";
     String BEYANNAME_VERI_AKTARMA_SEVKIYAT_HATTI = "sevkiyathatti";
     String BEYANNAME_VERI_AKTARMA_ATR_BELGE_NO = "atrbelgeno";
     String BEYANNAME_VERI_AKTARMA_ATR_BELGE_TARIHI = "atrbelgetarihi";
     String BEYANNAME_VERI_AKTARMA_ONSTATU_BELGE_NO = "onstatubelgeno";
     String BEYANNAME_VERI_AKTARMA_ONSTATU_BELGE_TARIHI = "onstatubelgetarihi";
     String BEYANNAME_VERI_AKTARMA_YATIRIM_TESVIK_BELGE_NO = "yatirimtesvikbelgeno";
     String BEYANNAME_VERI_AKTARMA_YATIRIM_TESVIK_TARIHI = "yatirimtesviktarihi";
     String BEYANNAME_VERI_AKTARMA_YURTDISI_DIGER = "yurtdisidiger";
     String BEYANNAME_VERI_AKTARMA_YURTDISI_DIGER_DOVIZI = "yurtdisidigerdovizi";
     String BEYANNAME_VERI_AKTARMA_MENSEI_SAH_BELGE_NO = "menseisahbelgeno";
     String BEYANNAME_VERI_AKTARMA_MENSEI_SAH_TARIHI = "menseisahtarihi";
     String BEYANNAME_VERI_AKTARMA_TPS_BELGE_NO = "tpsbelgeno";
     String BEYANNAME_VERI_AKTARMA_TPS_TARIHI = "tpstarihi";
     String BEYANNAME_VERI_AKTARMA_CIKIS_ULKE_LIMAN = "cikisulkeliman";
     String BEYANNAME_VERI_AKTARMA_GONDERICI_REFERANS = "gondericireferans";
     String BEYANNAME_VERI_AKTARMA_KONSIMANTO_NO = "konsimantono";
     String BEYANNAME_VERI_AKTARMA_KONTEYNER_NUMARA = "konteynernumara";
     String BEYANNAME_VERI_AKTARMA_GEMI_ADI = "gemiadi";
     String BEYANNAME_VERI_AKTARMA_TASIYICI_KODU = "tasiyicikodu";
     String BEYANNAME_VERI_AKTARMA_BOSALTMA_LIMANI = "bosaltmalimani";
     String BEYANNAME_VERI_AKTARMA_DIIB_BELGE_NO = "diibbelgeno";
     String BEYANNAME_VERI_AKTARMA_MUAFIYET = "muafiyet";
    String BEYANNAME_VERI_AKTARMA_DOVIZ_CINSI = "dovizcinsi";
    String BEYANNAME_VERI_AKTARMA_TESLIM_SEKLI = "teslimsekli";
    String BEYANNAME_VERI_AKTARMA_TASIMA_SEKLI = "tasimasekli";
    String BEYANNAME_VERI_AKTARMA_TAHMINI_HAREKET_TARIHI = "tahminiharekettarihi";
    String BEYANNAME_VERI_AKTARMA_TAHMINI_VARIS_TARIHI = "tahminivaristarihi";
    String BEYANNAME_VERI_AKTARMA_TIC_YAPILAN_ULKE = "ticyapilanulke";

    // Sbr_Ulke
    String ULKE_ID = "ulkeid";
    String ULKE_AD = "ad";
    String EDI_KOD = "edikod";
    String KODU = "kodu";
    String KISA_AD = "kisaad";
    String ORIJINAL_AD = "orijinalad";

    //sgm_malzemetanim
    String MALZEME_TANIM_ID = "malzemetanimid";
    String MALZEME_TANIM_FIRMA_ID = "firmaid";
    String MALZEME_TANIM_KOD = "kod";
    String MALZEME_TANIM_GTIP = "gtip";
    String TURKCE_AD = "turkcead";
    String ORJINAL_ADI = "orjinaladi";

    //sgm_beyannamesurec
    String BEYANNAME_SUREC_ID = "beyannamesurecid";
    String BEYANNAME_SUREC_BEYANNAME_ID = "beyannameid";
    String BEYANNAME_SUREC_SUREC_TANIM_ID = "surectanimid";
    String BEYANNAME_SUREC_TARIH = "tarih";

    // sbr_olcubirim
    String OLCU_BIRIM_ID = "olcubirimid";
    String OLCU_BIRIMI_EDI_KOD = "edikod";
    String CMS = "cms";

    // Foreign keys
    String PARENT_ID = "PARENT_ID";
    String EVENT_DEFINITION_ID = "EVENT_DEFINITION_ID";
    String DATA_TYPE_DEFINITION_ID = "DATA_TYPE_DEFINITION_ID";
    String CUSTOMER_EVENT_DEFINITION_ID = "CUSTOMER_EVENT_DEFINITION_ID";
    String EVENT_QUEUE_ID = "EVENT_QUEUE_ID";
    String DATA_TYPE_ATTRIBUTE_ID = "DATA_TYPE_ATTRIBUTE_ID";
    String DATA_REFERENCE_ID = "DATA_REFERENCE_ID";

    // Entity Names
    String CUSTOMER_ENTITY = "Customer";
    String EVENT_QUEUE_ENTITY = "EventQueue";
    String EVENT_QUEUE_LOG_ENTITY = "EventQueueLog";
    String EVENT_DEFINITION_ENTITY = "EventDefinition";
    String CUSTOMER_EVENT_DEFINITION_ENTITY = "CustomerEventDefinition";
    String DATA_TYPE_DEFINITION_ENTITY = "DataTypeDefinitionEntity";
    String DATA_REFERENCE_MAPPING_ENTITY = "DataReferenceMappingEntity";
    String DATA_TYPE_ATTRIBUTE_ENTITY = "DataTypeAttributeEntity";
    String DATA_REFERENCE_ENTITY = "DataReferenceEntity";
    String MANIFESTO_ENTITY = "ManifestoEntity";
    String MALZEME_ENTITY = "MalzemeEntity";
    String FIRMA_ENTITY = "FirmaEntity";
    String BEYANNAME_ENTITY = "BeyannameEntity";
    String BEYANNAME_VERI_AKTARMA_ENTITY = "BeyannameVeriAktarmaEntity";
    String ULKE_ENTITY = "UlkeEntity";
    String OLCU_BIRIM_ENTITY = "OlcuBirimEntity";
    String MALZEME_TANIM_ENTITY = "MalzemeTanimEntity";
    String BEYANNAME_SUREC_ENTITY = "BeyannameSurec";

    // WHERE clause
    String CUSTOMER_WHERE_CLAUSE = "DELETE_DATE is null";
    String EVENT_DEFINITION_WHERE_CLAUSE = "DELETE_DATE is null";
    String CUSTOMER_EVENT_DEFINITION_WHERE_CLAUSE = "DELETE_DATE is null";
    String EVENT_QUEUE_WHERE_CLAUSE = "DELETE_DATE is null";
    String EVENT_QUEUE_LOG_WHERE_CLAUSE = "DELETE_DATE is null";
    String DATA_TYPE_DEFINITION_WHERE_CLAUSE = "DELETE_DATE is null";
    String DATA_REFERENCE_MAPPING_WHERE_CLAUSE = "DELETE_DATE is null";
    String DATA_TYPE_ATTRIBUTE_WHERE_CLAUSE = "DELETE_DATE is null";
    String DATA_REFERENCE_WHERE_CLAUSE = "DELETE_DATE is null";
    String MANIFESTO_WHERE_CLAUSE = "DELETE_DATE is null";
    String BEYANNAME_WHERE_CLAUSE = "DELETE_DATE is null";


    // Delete sqls
    String CUSTOMER_DELETE_SQL = "UPDATE Customer SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String EVENT_DEFINITION_DELETE_SQL = "UPDATE EventDefinition SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String CUSTOMER_EVENT_DEFINITION_DELETE_SQL = "UPDATE CustomerEventDefinition SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String EVENT_QUEUE_DELETE_SQL = "UPDATE EventQueue SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String EVENT_QUEUE_LOG_DELETE_SQL = "UPDATE EventQueueLog SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String DATA_TYPE_DEFINITION_DELETE_SQL = "UPDATE DataTypeDefinitionEntity SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String DATA_REFERENCE_MAPPING_DELETE_SQL = "UPDATE DataReferenceMappingEntity SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String DATA_TYPE_ATTRIBUTE_DELETE_SQL = "UPDATE DataTypeAttributeEntity SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String DATA_REFERENCE_DELETE_SQL = "UPDATE DataReferenceEntity SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String MANIFESTO_DELETE_SQL = "UPDATE ManifestoEntity SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";
    String BEYANNAME_DELETE_SQL = "UPDATE BeyannameEntity SET delete_date = CURRENT_TIMESTAMP WHERE id =? and version =? ";



}
