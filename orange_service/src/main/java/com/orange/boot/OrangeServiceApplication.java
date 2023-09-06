package com.orange.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.orange.boot.**.mapper")
public class OrangeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeServiceApplication.class, args);
    }
}
