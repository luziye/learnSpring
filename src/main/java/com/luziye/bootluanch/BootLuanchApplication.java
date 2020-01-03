package com.luziye.bootluanch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.luziye.bootluanch.generator"})
@EnableAsync
@EnableScheduling
public class BootLuanchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLuanchApplication.class, args);
    }

}
