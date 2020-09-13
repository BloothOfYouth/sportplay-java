package com.hjf.sportplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 开启注解事务管理
@MapperScan("com.hjf.sportplay.dao")
@SpringBootApplication
public class SportplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportplayApplication.class, args);
    }

}
