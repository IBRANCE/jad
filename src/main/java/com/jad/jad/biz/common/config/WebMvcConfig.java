//package com.jad.jad.biz.common.config;
//
//import com.jad.jad.biz.interceptor.ServerControlInterceptor;
//import jakarta.annotation.Resource;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurationSupport {
//
//    @Resource
//    private ServerControlInterceptor serverControlInterceptor;
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(serverControlInterceptor).addPathPatterns("/user/**");
//    }
//}
