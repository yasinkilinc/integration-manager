package tr.com.atez.integration.manager.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class DateUtils {

    public static final String DATETIME_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";

    public static LocalDateTime convert(String dateStr){
        if(checkIsNull(dateStr)){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
        return LocalDateTime.parse(dateStr, formatter);
    }

    public static LocalDateTime convertZeroTime(Object dateObj){
        if(checkIsNull(dateObj)){
            return null;
        }
        LocalDateTime localDateTime = convert(dateObj);
        return localDateTime.with(LocalTime.of(0, 0, 0));
    }

    public static LocalDateTime convert(Object dateObj){
        if(checkIsNull(dateObj)){
            return null;
        }
        return convert(String.valueOf(dateObj));
    }

    public static boolean checkIsNull(Object dataObj){
        return dataObj == null;
    }

}
