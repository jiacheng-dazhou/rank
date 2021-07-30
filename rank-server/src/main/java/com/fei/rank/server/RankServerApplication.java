package com.fei.rank.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fei.rank"})
@MapperScan(basePackages = {"com.fei.rank.application.dao"})
public class RankServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RankServerApplication.class, args);
    }

}
