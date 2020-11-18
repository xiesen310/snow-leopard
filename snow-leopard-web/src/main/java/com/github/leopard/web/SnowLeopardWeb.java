package com.github.leopard.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 谢森
 * @Description SnowLeopardWeb 启动类
 * @Email xiesen310@163.com
 * @Date 2020/11/18 18:10
 */
@SpringBootApplication(scanBasePackages = {"com.github.leopard.service", "com.github.leopard.web.controller", "com" +
        ".github.leopard.web.config", "com.github.leopard.web.exception"})
@MapperScan({"com.github.leopard.dao"})
public class SnowLeopardWeb {
    public static void main(String[] args) {
        SpringApplication.run(SnowLeopardWeb.class, args);
    }
}
