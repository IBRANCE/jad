package com.jad.jad.biz.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author nice
 * @create 2022/1/25 11:19 上午
 * @desc
 */
public class FileBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel fileChannel = aFile.getChannel();

        // 创建一个缓冲区，用来处理数据，分配空间大小为48字节
        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = fileChannel.read(buf);

        while (bytesRead != -1) {
            // 将缓冲区切换为读模式
            buf.flip();

            System.out.println("缓冲区当前读取数据的位置为：" + buf.position());

            // limit就是数据的长度
            System.out.println("缓冲区可读取数据的长度为：" + buf.limit());

            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());

                System.out.println("===> 缓冲区当前读取数据的位置为：" + buf.position());
            }

            // 将缓冲区切换为写模式，清空数据
            buf.clear();
            bytesRead = fileChannel.read(buf);
        }

        aFile.close();
    }
}
