package com.yefei.securityweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.yefei.securityweb.dao"})
public class SecurityWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityWebApplication.class, args);
    }

}
