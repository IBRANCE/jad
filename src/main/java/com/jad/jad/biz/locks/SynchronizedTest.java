package com.jad.jad.biz.locks;

public class SynchronizedTest {


    /**
     * synchronized 的使用方式以及背后原理
     */
    public void synchronizedTest01() {

        synchronized(this) {
            // doSomething
            // 直接打印执行线程的名字
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 整个方法都加锁
     */
    public synchronized void synchronizedTest02() {

        // doSomething 

    }

    /**
     * 锁是当前类Class对象
     */
    public static synchronized void synchronizedTest03() {

    }


    public static void main(String[] args) {
        
        SynchronizedTest lockTest = new SynchronizedTest();
        // 多线程下，执行01方法
        Thread t1 = new Thread(() -> {
            lockTest.synchronizedTest01();
        });

        Thread t2 = new Thread(() -> {
            lockTest.synchronizedTest01();
        });


        t1.start();
        t2.start();



    }















}
