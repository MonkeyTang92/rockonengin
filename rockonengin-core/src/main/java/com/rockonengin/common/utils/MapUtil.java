package com.rockonengin.common.utils;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;


public class MapUtil {
    public static String BuildString(Map<String, Object> para) {
        return "";
    }


    public static Map<String, Object> buildMap(Object... array) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; (i + 1) < array.length; i += 2) {
            map.put(array[i] + "", array[i + 1]);
        }
        return map;
    }


    public static Map<String, String> buildMap(String... array) {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; (i + 1) < array.length; i += 2) {
            map.put(array[i], array[i + 1]);
        }
        return map;
    }

    public static Map<String, Object> changeMapKeyWithNoPackage(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> keys = new ArrayList<String>();
        for (String key : params.keySet()) {
            if (params.get(key) instanceof Map) {
                changeMapKeyWithNoPackage((Map<String, Object>) params.get(key));
            }
            if (params.get(key) instanceof List) {
                for (Object obj : (List) params.get(key)) {
                    if (obj instanceof Map) {
                        changeMapKeyWithNoPackage((Map<String, Object>) obj);
                    }
                }
            }
            String[] keyArray = key.split("\\.");
            if (keyArray.length > 1) {
                keys.add(key);
                map.put(keyArray[keyArray.length - 1], params.get(key));
            }
        }
        params.putAll(map);
        for (String delKey : keys) {
            params.remove(delKey);
        }
        return params;
    }


    public static boolean mapEquals(Map<String, Object> map1, Map<String, Object> map2, LinkedList<String> stackField, List<String> notMatchField, List<String> ignoreFields) {
        if (map1 == null && map2 == null) return true;
        if (map1 == null && map2 != null || map1 != null && map2 == null) {
            if (stackField.size() > 0) {
                notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
            }
            return false;
        }

        boolean match = true;
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        for (Map.Entry<String, Object> entry : map1.entrySet()) {
            stackField.addLast(entry.getKey());

            //判断是否忽略字段
            String fullKey = StringUtils.collectionToDelimitedString(stackField, "->");
            if (fullKey.equals("batch-execution->insert->ppdaidrools.loyalcustomeraudit.LoyalCustomerAudit->taoBaoStatus->int")) {
                System.out.println(fullKey);
            }
            boolean isIgnoreThisField = false;
            for (String ignoreField : ignoreFields) {
                if (antPathMatcher.match(ignoreField, fullKey)) {
                    isIgnoreThisField = true;
                    break;
                }
            }
            if (isIgnoreThisField) {
                stackField.removeLast();
                continue;
            }

            String key1 = entry.getKey();
            Object value1 = entry.getValue();
            Object value2 = map2.get(key1);
            if (value1 instanceof Map) {
                if (value2 instanceof Map) {
                    if (!mapEquals((Map) value1, (Map) value2, stackField, notMatchField, ignoreFields)) {
                        match = false;
                    }
                } else {
                    notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
                    match = false;
                }
            } else if (value1 instanceof List) {
                if (value2 instanceof List) {
                    if (!listEquals((List) value1, (List) value2, stackField, notMatchField, ignoreFields)) {
                        match = false;
                    }
                } else {
                    notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
                    match = false;
                }
            } else {
                value1 = StringUtil.objectTrim(value1);
                value2 = StringUtil.objectTrim(value2);

                if (!ObjectUtils.nullSafeEquals(value1, value2)) {
                    notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
                    match = false;
                }
            }

            stackField.removeLast();
        }

        return match;
    }


    private static boolean listEquals(List list1, List list2, LinkedList<String> stackField, List<String> notMatchField, List<String> ignoreFields) {
        if (list1 == null && list2 == null) return true;
        if (list1 == null && list2 != null || list1 != null && list2 == null) {
            if (stackField.size() > 0) {
                notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
            }
            return false;
        }
        if (list1.size() != list2.size()) {
            notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            stackField.addLast("[" + i + "]");

            Object value1 = list1.get(i);
            Object value2 = list2.get(i);

            if (value1 instanceof Map) {
                if (value2 instanceof Map) {
                    if (!mapEquals((Map) value1, (Map) value2, stackField, notMatchField, ignoreFields)) {
                        stackField.removeLast();
                        return false;
                    }
                } else {
                    notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
                    stackField.removeLast();
                    return false;
                }
            } else if (value1 instanceof List) {
                if (value2 instanceof List) {
                    if (!listEquals((List) value1, (List) value2, stackField, notMatchField, ignoreFields)) {
                        stackField.removeLast();
                        return false;
                    }
                } else {
                    notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
                    stackField.removeLast();
                    return false;
                }
            } else {
                value1 = StringUtil.objectTrim(value1);
                value2 = StringUtil.objectTrim(value2);

                if (!ObjectUtils.nullSafeEquals(value1, value2)) {
                    notMatchField.add(StringUtils.collectionToDelimitedString(stackField, "->"));
                    stackField.removeLast();
                    return false;
                }
            }
            stackField.removeLast();
        }
        return true;
    }
}
