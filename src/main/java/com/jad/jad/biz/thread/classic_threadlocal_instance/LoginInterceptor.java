//package com.jad.jad.biz.thread.classic_threadlocal_instance;
//
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// * @author nice
// * @desc 登录拦截器
// */
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        // 解析请求中的cookie
//        request.getCookies();
//
//        ThreadLocalHolder.putVal("obj");
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        ThreadLocalHolder.remove();
//    }
//
//}
