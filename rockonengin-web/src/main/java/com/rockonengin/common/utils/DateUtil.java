package com.rockonengin.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by tangfan on 2017/12/03.
 */
public class DateUtil {

    /*
    * 新增日期
    * */
    public static Date add(Date currentDate, int num, int addDateType) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);
        calendar.add(addDateType, num);//把日期往后增加一天.整数往后推,负数往前移动
        Date date = calendar.getTime();   //这个时间就是日期往后推一天的结果
        return date;
    }

    public static String dateToString(Date time, String format) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(format);
        String ctime = formatter.format(time);
        return ctime;
    }

    /*
    * 格式化日期 yyyy-MM-dd HH:mm:ss
    * */
    public static String format(Date date) {
        if (date == null) return "";
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime = formatter.format(date);
        return ctime;
    }

    /*
    * 根据传入的pattern格式化日期
    * */
    public static String format(Date date, String pattern) {
        if (date == null || CommonUtil.isEmpty(pattern)) return "";
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(pattern);
        String ctime = formatter.format(date);
        return ctime;
    }

    /*
    * 根据pattern 将字符串转为date (中国时间)
     */
    public static Date stringToDate(String dateStr,String pattern) throws ParseException {
        if(CommonUtil.isEmpty(dateStr)|| CommonUtil.isEmpty(pattern))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
        Date date = sdf.parse(dateStr);
        return date;
    }
}
