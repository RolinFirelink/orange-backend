package com.orange.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author CZF
 * @create 2022-03-20 18:55
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {



    //配置本地文件映射到url上
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 图片资源转发
         */
        String uploadDetailDiseasePath = "/root/platform/orange/img/";
        registry.addResourceHandler("/news/**")
                .addResourceLocations("file:" + uploadDetailDiseasePath);

    }
}


