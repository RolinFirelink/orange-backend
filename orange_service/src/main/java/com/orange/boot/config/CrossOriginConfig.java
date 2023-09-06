package com.orange.boot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: lzh
 * @Date: 2022/4/20 19:56
 */


@Configuration
public class CrossOriginConfig {

    // 当前跨域请求最大有效时长。这里默认1天
   // private static final long MAX_AGE = 24 * 60 * 60;
    private static final long MAX_AGE =  3 * 60;

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1 设置访问源地址
        corsConfiguration.addAllowedHeader("*"); // 2 设置访问源请求头
        corsConfiguration.addAllowedMethod("*"); // 3 设置访问源请求方法
        corsConfiguration.setMaxAge(MAX_AGE);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
        return new CorsFilter(source);
    }

}

/*@Configuration // 全局配置类-- 跨域请求
//WebMvcConfigurerAdapter 这个过时了，换成WebmvcConfigurer
public class CrossOriginConfig implements WebMvcConfigurer {

        *//**   ```1
         *  1.  与访问路径
         *  2.  请求来源
         *  3.  方法
         *  4.  允许携带a
         *  5.  最大响应时间
         *//*
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOriginPatterns("*")   // "http://175.178.222.176:8081","http://175.178.222.176:9199"
                    .allowedHeaders("Access-Control-Allow-Origin")
                    .allowedHeaders("Access-Control-Allow-Headers")
                    .allowedMethods("GET","POST","OPTIONS","DELETE","PUT")
                    .allowCredentials(true)
                    .maxAge(3600);

        }
}*/




