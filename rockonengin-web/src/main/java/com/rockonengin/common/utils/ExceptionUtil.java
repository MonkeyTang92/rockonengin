package com.rockonengin.common.utils;

import org.springframework.util.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by tangfan on 2017/12/03.
 */
public class ExceptionUtil {
    public static String getMessage(Throwable throwable){
        String message = throwable.getMessage();
        if(!StringUtils.hasText(message)){
            message="系统繁忙 ，稍后再试！";
        }
        return  message;
    }

    public static String getStackTrace(Throwable throwable){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }

}
