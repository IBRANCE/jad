package com.jad.jad.biz.datastructure;

import java.util.Arrays;

/**
 * @author nice
 * @date 2022/2/28
 * @desc 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个棋盘，11X11
        int[][] chessArr = new int[11][11];

        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        System.out.println("原始二维数组=====");
        for (int[] ints : chessArr) {
            System.out.println(Arrays.toString(ints));
        }

        // 将二维数组转换为稀疏数组

        // 读取原始数组的行和列
        // 读取原始数组中的有效值的个数
        int sum = 0;

        for (int i = 0; i < chessArr.length; i++) {
            // 行
            int[] chessLine = chessArr[i];
            for (int j = 0; j < chessLine.length; j++) {
                int val = chessLine[j];
                if (val != 0) {
                    sum ++;

                }
            }
        }


        int [][] sparseArr = new int[3][3];





    }

}
