package com.bubudeai.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public static String formatTime(LocalDateTime date){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = df.format(date);
        return format;
    }


    /**
     * 解析：从String到Date
     */
    public static LocalDateTime formatTime(String time){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime parse = LocalDateTime.parse(time, df);

        return parse;
    }

    public static LocalDate getLocalDate(){
        LocalDate now = LocalDate.now();
        return now;
    }

    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
    }

}
