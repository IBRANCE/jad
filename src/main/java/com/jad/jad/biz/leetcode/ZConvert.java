package com.jad.jad.biz.leetcode;


/**
 * @author nice
 * @create 2022/3/1 11:54 AM
 * @desc z字形转换 https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class ZConvert {

    public static void main(String[] args) {
        ZConvert zConvert = new ZConvert();
        String afterStr = zConvert.convert("PAYPALISHIRING", 4);
        System.out.println("afterStr = " + afterStr);
        System.out.println("correctStr = PAHNAPLSIIGYIR");
    }


    // TODO 没搞出来，fuck
    public String convert(String s, int numRows) {
        int strLen = s.length();
        StringBuilder sb = new StringBuilder();
        // 第一行数据
        sb.append(s.charAt(0));
        int n  = 1;
        int index = (int) (Math.pow(2, n) * (numRows - 1));


        // 记录第一行的索引值
        int[] indexArr = new int[numRows + 1];
        while (index < strLen) {
            sb.append(s.charAt(index));
            n ++;
            index = (int) (Math.pow(2, n) * (numRows - 1));
        }

        // 第二行数据



        sb.append(s.charAt(1));



        // 第三行
        sb.append(s.charAt(2));


        // 最后一行


        return sb.toString();
    }

}
