package com.rockonengin.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);
    public static int extractAgeFromIdNum(String idNum)  {
        int age = 0;
        if(!StringUtils.hasText( idNum )|| idNum.trim().length()<15){
            return age;
        }

        try {
            Date ageDate = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            if(idNum.trim().length()>15){
                ageDate=simpleDateFormat.parse(idNum.trim().substring(6,14));
            }else{
                ageDate=simpleDateFormat.parse("19"+idNum.trim().substring(6,12));
            }
            Date currentDate = simpleDateFormat.parse( simpleDateFormat.format(new Date()) );
            age = currentDate.getYear() - ageDate.getYear();
            currentDate.setYear( currentDate.getYear() - age );
            if(currentDate.getTime() <  ageDate.getTime() ){
                age--;
            }
        } catch (ParseException e) {
            LOGGER.error("StringUtil 年龄转换异常",e);
        }

        return age;
    }

    public static String blankString(String str){
        if(str == null){
            return "";
        }
        return str;
    }

    public static String getString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static int getInt(Object obj) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (Exception e) {
            LOGGER.error("StringUtil 对象转换int异常",e);
            return 0;
        }
    }

    public static boolean isDigit(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            LOGGER.error("StringUtil 数字类型转换异常",e);
            return false;
        }
    }

    public static String changeEnc(String s, String oldEnc, String newEnc) {
        try {
            return new String(s.getBytes(oldEnc), newEnc);
        } catch (Exception e) {
            LOGGER.error("StringUtil 编码转换异常",e);
            return s;
        }
    }

    public static String formatRate(float rate) {
        DecimalFormat df = new DecimalFormat("##.##");
        return df.format(rate);
    }

    public static String formatAmount(float amount) {
        DecimalFormat df = new DecimalFormat("¥###,###,###.##");
        return df.format(amount);
    }

    public static String formatAmount(String pattern, double amount) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(amount);
    }

    public static Object objectTrim(Object obj){
        if(obj!=null && obj instanceof String){
            return ((String) obj).trim();
        }
        return obj;
    }

    public static String envName(String envCode){
        if("test".equals(envCode)){
            return "测试环境";
        }else if("dev".equals(envCode)){
            return "开发环境";
        }else if("local".equals(envCode)){
            return "本地环境";
        }
        return "";
    }

    public static boolean isBlank(String str){
        return (null == str|| str.trim().length()==0);
    }

    public static String extractGenderFromIdNum(String idNum) {
        if(!StringUtils.hasText( idNum )|| idNum.trim().length()<15){
            return "";
        }

        int gender=0;
        try {
            if( idNum.trim().length() ==15  ){
                gender= Integer.parseInt(idNum.trim().substring(14));
            }else if( idNum.trim().length() ==18  ){
                gender= Integer.parseInt(idNum.trim().substring(16, 17));
            }
        } catch (NumberFormatException e) {
            LOGGER.error("StringUtil 数字格式化异常",e);
            return "";
        }

        return gender%2==0?"女":"男";
    }
}
