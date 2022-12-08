package com.jad.jad.biz.adapter;

import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

public class MyRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {

    @Override
    public void setRequestBodyAdvice(List<RequestBodyAdvice> requestBodyAdvice) {
        super.setRequestBodyAdvice(requestBodyAdvice);
    }

    

}
