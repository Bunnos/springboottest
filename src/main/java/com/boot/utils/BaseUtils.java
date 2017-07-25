package com.boot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/5.
 */
public class BaseUtils {
    public static String formatDate(Date date, String format){
        if(date==null){
            date=new Date();
        }
        if(format==null||"".equalsIgnoreCase(format)){
            format="yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df=new SimpleDateFormat(format);
        return df.format(date);
    }
}
