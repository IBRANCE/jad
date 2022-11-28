package com.jad.jad.biz.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author nice
 * @date 2022/2/24
 * @desc
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrierTest cbt = new CyclicBarrierTest();
        cbt.testCycle();
    }


    public void testCycle() {
        // 只有5个线程同时等待时，线程才能继续执行
        CyclicBarrier cb  = new CyclicBarrier(2);

        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            es.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "线程等待中。。。");

                try {
                    // 线程阻塞
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + "线程继续执行。。。");
            });
        }

        es.shutdown();
    }

}
