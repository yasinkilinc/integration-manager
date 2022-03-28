package tr.com.atez.integration.manager.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenericUtils {
    private GenericUtils() {
    }

    public static boolean isNullOrEmptyObject(Object obj) {
        return obj == null || obj == "";
    }

    public static final String formatLocalDateTimeAsString(LocalDateTime localDateTime, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return localDateTime.format(formatter);
    }
}
