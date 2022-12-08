package com.jad.jad.biz.retry.myretry;

import com.jad.jad.biz.retry.myretry.annotation.MyRetry;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Predicate;

/**
 * 重试工具类，使用一个方法完成重试的需求
 */
public class RetryUtil {

    /**
     * 重试方法
     *
     * @param method 需要重试的方法
     * @param obj 调用重试方法的对象
     * @return
     */
    public static Object retry(Method method, Object obj) {
        // 方法的入参列表
//        method.invoke(obj, )


        return null;
    }


    private static class RetryConfig {

        int retryTimes = 3;
         boolean retryFlag = true;

        private List<RetryPolicy> policies;

        public RetryConfig() {

        }

        public static RetryConfig retryTimes(int retryTimes) {

            return null;
        }

        public void setRetryFlag(boolean retryFlag) {
            this.retryFlag = retryFlag;
        }

    }

    private static class RetryPolicy {

    }

    public static void main(String[] args) {

//        RetryUtil.retry()
    }

    @MyRetry
    private void test() {

    }

}
