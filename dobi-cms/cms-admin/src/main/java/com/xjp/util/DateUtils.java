package com.xjp.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by xjpdy on 2017/8/2.
 */
public class DateUtils {

    /**
     * String转java.sql.Date
     * @param string yyyy-MM-dd
     * @return
     */
    public static Date string2Date(String string){
        return Date.valueOf(string);
    }
}
