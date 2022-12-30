package com.jad.jad.biz.filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

import java.nio.charset.StandardCharsets;

/**
 * 布隆过滤器的实现思路
 * 根据mebId判断数据库中是否存在数据。
 */
public class BloomFilterTest {

    public static void main(String[] args) throws InterruptedException {
        BloomFilter<String> bf = BloomFilter.create((Funnel<String>) (from, into) -> into.putString(from, StandardCharsets.UTF_8),
                100000000);

        for (int i = 0; i < 100000000; i++) {
            bf.put(i + "");
        }

        System.out.println("执行完毕");
        // 怎么查看内存占用
        Thread.sleep(20000000);

        boolean flag = bf.mightContain("0");
        System.out.println("flag = " + flag);
    }

}
