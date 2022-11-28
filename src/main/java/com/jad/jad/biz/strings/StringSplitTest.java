package com.jad.jad.biz.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author nice
 * @create 2022/2/25 11:21 AM
 * @desc 测试 split()方法
 */
public class StringSplitTest {

    public static void main(String[] args) {
        StringSplitTest sst = new StringSplitTest();
        sst.test();
    }

    public void test() {
        // 正则表达式
        Pattern pattern = Pattern.compile("n{1,3}+");
        Matcher matcher = pattern.matcher("nnnn");
        System.out.println("是否匹配成功 + " + matcher.matches());

    }

}
