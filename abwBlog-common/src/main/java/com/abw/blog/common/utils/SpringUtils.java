package com.abw.blog.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by fanghuabao on 2018/4/26 0026.
 */
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext ac;
    private static Logger logger = LoggerFactory.getLogger(SpringUtils.class);

    public SpringUtils() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public static <T> T getBean(String beanId, Class<T> type) {
        return ac.getBean(beanId, type);
    }

    public static <T> T getBean(Class<T> type) {
        return ac.getBean(type);
    }

    public static <T> T getBean(String beanId) {
        return (T)ac.getBean(beanId);
    }


}

