package com.jad.jad.biz.nio.channel;


import java.nio.Buffer;
import java.nio.channels.*;

/**
 * @author nice
 * @create 2022/1/25 10:38 上午
 * @desc 通道
 */
public class ChannelTest {

    public static void main(String[] args) {

        //
        SocketChannel socketChannel;

        // 文件
        FileChannel fileChannel;

        // UDP协议
        DatagramChannel datagramChannel;

        // TCP协议
        ServerSocketChannel serverSocketChannel;

        // 选择器：
        Selector selector;

        // 缓冲区，用来暂时存储数据
        Buffer buffer;
    }

}
