package com.gosuncn.pfr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gosuncn.pfr.mapper")
public class PfrApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfrApplication.class, args);
    }



}
