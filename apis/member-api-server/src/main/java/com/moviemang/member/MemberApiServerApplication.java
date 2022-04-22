package com.moviemang.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.moviemang", "com.moviemang.datastore"})
@SpringBootApplication
public class MemberApiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApiServerApplication.class, args);
    }    
}