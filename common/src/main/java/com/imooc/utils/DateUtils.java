package com.imooc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parse(String value) throws ParseException {
        return simpleDateFormat.parse(value);
    }
}
