package com.jad.jad.biz.web.thread.safe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.net.URLDecoder;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 测试多线程安全的问题
 */
@RestController
@RequestMapping("/thread/safe")
public class ThreadSafeController {

    private int code;

    @GetMapping("/01")
    public void test01() {
        code += 1;
//        URLDecoder.decode();

        System.out.println(Thread.currentThread().getName() + "code = " + code);
    }

    public static void main(String[] args) {
        Boolean isJson = true, isPost = true;
        
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        changeStatus(atomicBoolean);

        System.out.println("atomicBoolean.get() = " + atomicBoolean.get());

    }

    private static void changeStatus(AtomicBoolean isJson) {
        isJson.set(false);
    }


}
