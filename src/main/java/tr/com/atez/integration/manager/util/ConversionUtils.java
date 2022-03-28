package tr.com.atez.integration.manager.util;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ConversionUtils {

    private static final ConversionService conversionService = DefaultConversionService.getSharedInstance();

    public static Float convert(Object obj){
        if(null == obj){
            return null;
        }
        return conversionService.convert(obj, Float.class);
    }
/*
    public static Float convert(Object obj, int scale){
        if(null == obj){
            return null;
        }
        return BigDecimal.valueOf( conversionService.convert(obj, Float.class) )
                .setScale(scale, RoundingMode.HALF_UP)
                .floatValue();
    }
*/
    public static BigDecimal convert(Object obj, int scale){
        if(null == obj){
            return null;
        }

        if(obj instanceof Double){
            return BigDecimal.valueOf((Double)obj).setScale(scale, RoundingMode.HALF_UP);
        }
        return BigDecimal.valueOf(Double.valueOf((String)obj)).setScale(scale, RoundingMode.HALF_UP);
    }



}
