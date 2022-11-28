package com.jad.jad.biz.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private final Lock lock = new ReentrantLock();

    public void test01() {
        
        try {
            lock.lock();
            


        } finally {

            lock.unlock();
        }
    }




    public static void main(String[] args) {
        




    }

    
}
