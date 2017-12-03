package com.rockonengin.common.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Map;

public class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    public static final ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> T convertToObject(String jsonStr, Class<T> valueType) {

        try {
            if (jsonStr == null || jsonStr == "") {
                return null;
            }
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            LOGGER.error("convertToObject错误：", e);
        }
        return null;
    }

    public static <T> T convertToObject(String jsonStr, TypeReference<T> valueTypeRef) {
        try {
            if (jsonStr == null || jsonStr == "") {
                return null;
            }
            return objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e) {
            LOGGER.error("convertToObject错误：", e);
        }

        return null;
    }

    public static <T> T convertToObject(String jsonStr, JavaType javaType) {
        try {
            if (jsonStr == null || jsonStr == "") {
                return null;
            }
            return objectMapper.readValue(jsonStr, javaType);
        } catch (Exception e) {
            LOGGER.error("convertToObject错误：", e);
        }

        return null;
    }

    public static String convertToJson(Object object) {

        try {
            if (object == null) {
                return null;
            }
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.error("convertToJson错误：", e);
        }
        return null;
    }

    public static <T> T convertToObejctFromKey(String jsonStr, String key, Class<T> valueType)
    {
        try{
            JsonNode node = objectMapper.readTree(jsonStr);
            String nodeString=node.get(key).textValue();
            return convertToObject(nodeString,valueType);
        }catch (Exception e) {
            LOGGER.error("convertToObejctFromKey错误：", e);
        }
        return null;

    }
    public static String getNodeString(String jsonStr, String key)
    {
        try{
            JsonNode node = objectMapper.readTree(jsonStr);
            return node.get(key).textValue();

        }catch (Exception e) {
            LOGGER.error("getNodeString错误：", e);
        }
        return null;

    }
    public static JavaType BuildJavaType(Class<?> c1, Class<?> ...c2) {
        return objectMapper.getTypeFactory().constructParametricType(c1, c2);
    }
    public static <T> T convertToObject(Class<T> valueType, Map<String,Object> params) {
        try {
            if (params == null) {
                return null;
            }
            return objectMapper.readValue(objectMapper.writeValueAsString(params), valueType);
        } catch (Exception e) {
            LOGGER.error("BuildJavaType错误：", e);
        }
        return null;
    }
    public static <T> T convertToObject(Class<T> valueType, Object...params) {
        return convertToObject(valueType, MapUtil.buildMap(params));
    }

}