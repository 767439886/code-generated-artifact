package com.jfeat.am.module.set.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String getNowTime () {
        Date date = new Date() ;
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date) ;
        return format ;
    }
}
