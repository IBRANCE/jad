package com.jad.jad.biz.thread;

public class ThreadLocalTest {
    

    private ThreadLocal<Object> tl = new ThreadLocal<>();


    public void putVal(Object obj) {
        tl.set(obj);
    }

    public Object getVal() {
        return tl.get();
    }

    public void remove() {
        tl.remove();
    }

}
