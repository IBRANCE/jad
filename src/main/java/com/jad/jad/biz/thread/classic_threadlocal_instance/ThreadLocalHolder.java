package com.jad.jad.biz.thread.classic_threadlocal_instance;

public class ThreadLocalHolder {
    
    private static ThreadLocal<Object> tl = new ThreadLocal<>();
    
    public static void putVal(Object obj) {
        tl.set(obj);
    }
    
    public static Object getVal() {
        return tl.get();
    }
    
    public static void remove() {
        tl.remove();
    }


}
