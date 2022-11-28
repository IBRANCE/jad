package com.jad.jad.biz.leetcode;

import org.springframework.util.StringUtils;

/**
 * @author nice
 * @create 2022/2/25 10:32 AM
 * @desc 复数相乘计算
 * <p>
 * 什么是复数？
 * z = a + bi，其中a为实部，b为虚部，i为虚数单位。 i ^ 2 = -1 (i的平方等于-1)
 * <p>
 * 两个复数的乘积计算公式：
 */
public class ComplexNumberMultiply {

    public static void main(String[] args) {
        ComplexNumberMultiply cnm = new ComplexNumberMultiply();
        String num1 = "1+1i", num2 = "1+1i";

        String res = cnm.complexNumMulti(num1, num2);
        System.out.println("res = " + res);
    }

    /**
     * 计算两个复数的乘积
     *
     * @param multi1 复数1 a+bi
     * @param multi2 复数2 a+bi
     * @return 复数 a+bi
     */
    private String complexNumMulti(String multi1, String multi2) {
        // 1、将字符串转换为数组
        int[] ints1 = convertStrToComplexNum(multi1);
        int[] ints2 = convertStrToComplexNum(multi2);

        // 2、计算两个数组的计算值，并组合出一个复数
        int a = ints1[0] * ints2[0] + ints1[1] * ints2[1] * -1;
        int b = ints1[0] * ints2[1] + ints1[1] * ints2[0];

        return a + "+" + b + "i";
    }

    /**
     * 将复数转换为长度为2的数组
     *
     * @param multi
     * @return
     */
    private int[] convertStrToComplexNum(String multi) {
        String[] strings = multi.split("\\+|i");

        int[] rs = new int[2];
        for (int i = 0; i < strings.length; i++) {
            rs[i] = Integer.parseInt(strings[i]);
        }

        return rs;
    }


}
