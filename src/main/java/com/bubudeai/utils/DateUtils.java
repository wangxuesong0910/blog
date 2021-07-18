package com.bubudeai.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

//日期和时间操作的工具类
public class DateUtils {
    private DateUtils(){}

    /**
     * 获取当前时间
     * @return
     */
    public static Date getTime(){
        return new Date();
    }

    /**
     * 格式化：从Date到String
     * @return
     */
    public static String formatTime(Date date){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sd.format(date);
        return format;
    }

}
