package com.jad.jad.biz.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.netty.util.concurrent.DefaultThreadFactory;

public class ThreadPoolCreation {
    

    public void m1 () {
        ExecutorService es = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), 
        new DefaultThreadFactory("thread-pool-test"), 
        new ThreadPoolExecutor.AbortPolicy());
        es.execute(() -> {
            System.out.println("hello");
        });
    }

    public void m2() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        ExecutorService es3 = Executors.newCachedThreadPool();
        ExecutorService es4 = Executors.newSingleThreadScheduledExecutor();
    }


    public void m3() {
        ExecutorService es = Executors.newFixedThreadPool(5);

        // 使用execute方法提交任务
        es.execute(() -> {
            System.out.println("hello");
        });

        Future f = es.submit(() -> {
            System.out.println("hello");
        });

        f.isDone();
    }

}
