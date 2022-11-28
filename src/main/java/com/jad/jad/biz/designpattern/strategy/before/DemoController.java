package com.jad.jad.biz.designpattern.strategy.before;

/**
 * @author nice
 * @date 2022/1/22
 * @desc
 */
public class DemoController {

    public void moreBranch(int num) {
        switch (num) {
            case 1:
                System.out.println("这是第一个分支");
                break;
            case 2:
                System.out.println("这是第二个分支");
                break;
            case 3:
                System.out.println("这是第三个分支");
                break;
            default:
                System.out.println("这个是结束的语句");
        }

    }

}
