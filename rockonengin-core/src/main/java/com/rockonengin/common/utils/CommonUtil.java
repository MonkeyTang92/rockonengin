package com.rockonengin.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return StringUtils.isBlank((String) obj);
        } else if (obj instanceof Collection) {
            return ((Collection) obj).size() == 0 ? true : false;
        } else if (obj instanceof Map) {
            return ((Map) obj).size() == 0 ? true : false;
        }else if(obj.getClass().isArray()){
            return Array.getLength(obj) == 0 ? true : false;
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static String trimToEmpty(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return StringUtils.trimToEmpty(String.valueOf(obj));
        }
    }


    public static  Map<String,String> buildMap(String ...array){
        Map<String,String> map = new HashMap<String, String>();
        for( int i = 0 ; (i+1) < array.length ; i+=2 ){
            map.put(array[i],array[i+1]);
        }
        return map;
    }
}
