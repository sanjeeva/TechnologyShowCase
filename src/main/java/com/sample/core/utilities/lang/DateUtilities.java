package com.sample.core.utilities.lang;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateUtilities {

    private DateUtilities() {
        throw new UnsupportedOperationException("Utility modules should not be instantiated");
    }

    public static Date dateNow() {
        return new Date();
    }

    public static Timestamp timestampNow() {
        return new Timestamp(System.currentTimeMillis());
    }
    
    public static Calendar calendarNow() {
        return Calendar.getInstance();
    }
}
