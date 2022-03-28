package tr.com.atez.integration.manager.util;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import tr.com.atez.integration.manager.entity.MalzemeTanim;
import tr.com.atez.integration.manager.entity.OlcuBirim;
import tr.com.atez.integration.manager.entity.Ulke;

import java.util.Map;

public abstract class DbUtils {

    private static final ConversionService conversionService = DefaultConversionService.getSharedInstance();

    public static OlcuBirim getOlcuBirimi(Object obj, Map<String, OlcuBirim> allOlcuBirim){
        if(null == obj){
            return null;
        }

        String olcuBirimCms = conversionService.convert(obj, String.class);
        return allOlcuBirim.get(olcuBirimCms);
    }


    public static Ulke getUlke(Object obj, Map<String, Ulke> allUlke){
        if(null == obj){
            return null;
        }

        String ulkeKoduStr = conversionService.convert(obj, String.class);
        return allUlke.get(ulkeKoduStr);
    }

    public static MalzemeTanim getMalzemeTanim(Object obj, Map<String, MalzemeTanim> malzemeTanimMap){
        if(null == obj){
            return null;
        }
        String malzemeKodu = conversionService.convert(obj, String.class);
        return malzemeTanimMap.get(malzemeKodu);
    }


}
