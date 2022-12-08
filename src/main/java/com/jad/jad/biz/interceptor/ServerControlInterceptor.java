package com.jad.jad.biz.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.nio.charset.StandardCharsets;

@Component
public class ServerControlInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ServerControlInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.error("server control interceptor exec ing");

        ContentCachingRequestWrapper ccrw = new ContentCachingRequestWrapper(request);
        StreamUtils.copyToString(ccrw.getInputStream(), StandardCharsets.UTF_8);

        return true;
    }
}
