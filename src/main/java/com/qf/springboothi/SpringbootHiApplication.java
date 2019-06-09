package com.qf.springboothi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qf.springboothi.mapper")
public class SpringbootHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHiApplication.class, args);
    }

}
