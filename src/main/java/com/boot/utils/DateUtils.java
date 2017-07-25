package com.boot.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/10.
 */
public class DateUtils {

    /**
     * 时间戳转date
     * @param timeStamp
     * @return
     */
    public static Date timeStampToDate(long timeStamp) {
//        Date date = new Timestamp(timeStamp * 1000);
        return new Timestamp(timeStamp * 1000);
    }

}
