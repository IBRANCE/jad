package com.jad.jad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.jad.jad.biz.filter")
public class JadApplication {

    public static void main(String[] args) {
        SpringApplication.run(JadApplication.class, args);
    }

}
