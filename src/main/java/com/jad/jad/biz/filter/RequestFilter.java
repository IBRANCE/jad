package com.jad.jad.biz.filter;

import com.google.common.collect.Lists;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 请求过滤器，自定义请求
 */
@WebFilter(urlPatterns = "/user/**")
@Component
public class RequestFilter extends GenericFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    private static final StopWatch sw = new StopWatch();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        sw.start();
        logger.info("start exec request convert, ");
        // request --> MyRequest
        MyRequestWrapper myRequest = new MyRequestWrapper((HttpServletRequest) request);


        sw.stop();
        logger.info("stop exec request convert, use time {}ms", sw.getTotalTimeMillis());
        // continue filter
        chain.doFilter(myRequest, response);
    }



    private static class MyRequestWrapper extends HttpServletRequestWrapper {

        /**
         * 过滤之前的请求
         */
        private final HttpServletRequest originRequest;

        /**
         * 请求方式
         */
        private String method;

        /**
         * 请求体
         */
        private ServletInputStream sis;

        /**
         * URL中的参数
         */
        private String queryString;

        /**
         * content-type
         */
        private String contentType;


        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request the {@link HttpServletRequest} to be wrapped.
         * @throws IllegalArgumentException if the request is null
         */
        public MyRequestWrapper(HttpServletRequest request) {
            super(request);
            this.originRequest = request;
        }

        @Override
        public String getQueryString() {
            return queryString;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return sis;
        }

        public void setSis(String jsonBody) {
            StringReader sr = new StringReader(jsonBody);
//            sr.reset();
            this.sis = new ServletInputStream() {
                @Override
                public boolean isFinished() {
                    return false;
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setReadListener(ReadListener readListener) {

                }

                @Override
                public int read() throws IOException {
                    return sr.read();
                }
            };
        }

        @Override
        public String getContentType() {
            return contentType;
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            return HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(name) ?
                    new Vector<>(Lists.newArrayList(MediaType.APPLICATION_JSON_VALUE)).elements()
                    :
                    originRequest.getHeaders(name);
        }
    }

}
