package com.unab.apijava.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContexto implements ApplicationContextAware{

    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {

                CONTEXT = applicationContext;

    }

    public static Object getBean(String beanName){
        return CONTEXT.getBean(beanName);
    }
    
}
