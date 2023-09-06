package com.orange.boot.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author CZF
 * @create 2022-04-03 1:56
 *
 * 非spring容器中的对象 想要 使用容器中的对象
 * 方便在非spring管理环境中获取spring中的bean
 */

@Component
public class GetBeanUtils implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    //把spring容器的上下文引用赋值给工具类的applicationContext
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        GetBeanUtils.applicationContext = applicationContext;
    }

    /**
     * @param name 通过bean的名称从spring容器中获取
     * @return 返回想要获取的bean
     * @throws NoSuchBeanDefinitionException
     */
    public static Object getBean(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getBean(name);
    }

    /**
     * @param clazz 通过bean的类型从spring容器中获取
     * @return 返回想要获取的bean
     * @throws NoSuchBeanDefinitionException
     */
    public static <T> T getBean(Class<T> clazz) throws NoSuchBeanDefinitionException {
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过name和class获取Bean
     */
    public static <T> T getBean(String name, Class<T> clazz) throws NoSuchBeanDefinitionException{
        return applicationContext.getBean(name, clazz);
    }
}
