package com.rockonengin.common.utils;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringEnvironmentHolder implements EnvironmentAware {

    private static Environment ENV;

    public static String getProperty(String key) {
        return ENV.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return ENV.getProperty(key, defaultValue);
    }

    public static <T> T getProperty(String key, Class<T> clazz) {
        return ENV.getProperty(key, clazz);
    }

    @Override
    public void setEnvironment(Environment environment) {
        ENV = environment;
    }

}