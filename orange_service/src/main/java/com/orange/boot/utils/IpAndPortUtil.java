package com.orange.boot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author CZF
 * @create 2022-05-06 21:43
 *
 * 获取服务器ip和端口号工具类
 */
@Component
public class IpAndPortUtil {

    @Value("${server.port}") //从配置文件中获取当前项目端口号
    private String port;

    @Value("${ipAndPort}")
    private String ip;

    private static String ipPort;

    @PostConstruct
    public void setIpPort(){
        this.ipPort = ip+":"+port;
    }

    /**
     * 返回当前服务的ip和端口
     */
    public static String getIpAndPort(){
        return ipPort;
    }
}
