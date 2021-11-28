package com.bubudeai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
public class MysiteBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysiteBlogApplication.class, args);
    }

}
