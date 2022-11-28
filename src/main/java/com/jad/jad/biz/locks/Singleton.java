package com.jad.jad.biz.locks;

public class Singleton {
    
    private volatile static Singleton instance;


    private Singleton() {

    }

    /**
     * 双重检查锁定
     * 
     * @return
     */
    public static Singleton getInstance() {
        // 排除一部分已经创建的情况，防止加无用锁
        if (instance == null) {
            // 加类锁
            synchronized (Singleton.class) {
                // 多线程下，只能创建一个实例，防止重复创建
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
