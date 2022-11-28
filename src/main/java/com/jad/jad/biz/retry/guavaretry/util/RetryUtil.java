package com.jad.jad.biz.retry.guavaretry.util;

import java.lang.reflect.Method;

/**
 * 重试工具类
 * TODO 需求：直接在需要重试的地方调用，则自动重试该方法
 */
public class RetryUtil {
    
    /**
     * 当前执行的位置的方法
     */
    private Method method;



    public void retry() {
        // 初始化
        init();


    }

    private void init() {
        

    }


}
