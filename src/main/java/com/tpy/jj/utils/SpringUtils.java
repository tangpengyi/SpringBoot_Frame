package com.tpy.jj.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 获取Spring容器的bean
     * @param clazz
     * @return
     */
    public static Object getBean(String clazz){
        Object bean = applicationContext.getBean(clazz);
        return StringUtils.isEmpty(bean) ? null : bean;
    }


}
