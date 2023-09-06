package com.orange.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Rolin
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public static ThreadPoolExecutor getThreadPoolExecutor(){
        return new ThreadPoolExecutor(1,36,1, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
    }
}
