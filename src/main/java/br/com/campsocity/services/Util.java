package br.com.campsocity.services;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Util {
    public static final String DATE_FORMAT_TOKEN = "yyyyMMddHHmmssSSS";

    public static String getToken() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TOKEN);
        return MD5.generate(sdf.format(cal.getTime()));
    }
}
