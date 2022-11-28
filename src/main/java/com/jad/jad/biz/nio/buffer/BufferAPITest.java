package com.jad.jad.biz.nio.buffer;

import java.nio.CharBuffer;

/**
 * @author nice
 * @create 2022/1/25 11:56 上午
 * @desc
 */
public class BufferAPITest {
    public static void main(String[] args) {

        // 向Buffer中写数据的两种方式
        CharBuffer charBuffer = CharBuffer.allocate(1024);

        // 第一种： put()方法向buffer中写入数据
        charBuffer.put("test");

        // 第二种：从channel中向buffer写入数据
        charBuffer.get();

    }

}
