package com.jad.jad.biz.filter;

import com.google.common.util.concurrent.RateLimiter;
import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 流量控制器
 * 本地限流器，只能限制单机的流量，不适合用于生产环境。
 */
//@Order(2)
//@WebFilter(urlPatterns = "/**")
//@Component
public class LocalLimitFilter extends GenericFilter {

    private static final Logger logger = LoggerFactory.getLogger(LocalLimitFilter.class);

    /**
     * 可设置tps值
     */
    RateLimiter rateLimiter = RateLimiter.create(1);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        logger.info("流控前，rate值为 {}", rateLimiter.getRate());
        if (rateLimiter.tryAcquire()) {
            logger.info("符合流控规则，可正常执行，rate值为{}", rateLimiter.getRate());
            chain.doFilter(request, response);
        } else {
            logger.info("不符合流控规则，不允许继续执行，rate值为{}", rateLimiter.getRate());
        }
    }

}
