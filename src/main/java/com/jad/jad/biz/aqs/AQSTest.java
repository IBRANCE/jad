package com.jad.jad.biz.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nice
 * @create 2022/2/24 7:02 PM
 * @desc 测试juc下的aqs的类
 */
public class AQSTest {


    public static void main(String[] args) throws InterruptedException {
        AQSTest at = new AQSTest();
        at.test();
    }


    public void test() throws InterruptedException {
        // 创建可重入锁，默认不公平锁
        ReentrantLock nonFairLock = new ReentrantLock();
        // 创建公平锁 Lock fairLock = new ReentrantLock(true);

        // 测试线程1持有这个锁，线程2尝试获取这个锁，这时的场景
        Thread t1 = new Thread(() -> {
            // 线程1占有锁
            nonFairLock.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                nonFairLock.unlock();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            // 线程2尝试获取锁
            nonFairLock.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                nonFairLock.unlock();
            }
        }, "t2");

        Thread t3 = new Thread(() -> {
            // 线程2尝试获取锁
            nonFairLock.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                nonFairLock.unlock();
            }
        }, "t3");

        Thread t4 = new Thread(() -> {
            // 线程3打印当前锁的持有人
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                System.out.println("nonFairLock = " + nonFairLock);
                // 等待队列的长度
                System.out.println(nonFairLock.getQueueLength());
            }
        }, "t4");

        t1.start();

        t2.start();
        // 为了确保t2比t3先启动，先进入等待队列
        Thread.sleep(100);
        t3.start();
        t4.start();
    }

}
