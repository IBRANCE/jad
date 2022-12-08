package com.jad.jad.biz.retry.myretry.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRetry {

    /**
     * 重试次数
     */
    int retryTimes() default 3;

    /**
     * 当发生异常时，才进行重试
     */
    Class<? extends Throwable>[] throwable() default {};

    /**
     * 达到重试次数后，依然失败，则返回默认值
     */
//    Object[] defaultVal() default {};

}
