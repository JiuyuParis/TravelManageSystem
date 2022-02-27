package com.travles.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TravelApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(TravelApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    //参数为当前 SpringBoot 启动类
    return builder.sources(TravelApplication.class);
    }
}
