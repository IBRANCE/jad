package com.jad.jad.biz.common;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

public class ToStringTest {

    /**
     * 结论：【i + "" 】比 String.valueOf()要快
     */
    @Test
    public void test() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 1000000; i++) {
            String val = String.valueOf(i);
        }
        stopWatch.stop();
        System.out.println("valueOf exec time " + stopWatch.getLastTaskTimeMillis() + "ms");



        stopWatch.start();
        for (int i = 0; i < 1000000; i++) {
            String val = i + "";
        }
        stopWatch.stop();
        System.out.println("second exec time " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("second exec time " + stopWatch.getTotalTimeMillis() + "ms");
    }

}
