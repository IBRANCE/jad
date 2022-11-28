package com.jad.jad.biz.designpattern.strategy.after;

/**
 * @author nice
 * @date 2022/1/22
 * @desc 公共策略的接口
 */
public interface BaseStrategy {

    /**
     * 每个策略的所要做的事情
     */
    void action();


    // 接口中可以定义静态方法，以及默认方法
    static BaseStrategy getInstance(int num) {
        switch (num) {
            case 1:
                return new FirstStrategyImpl();
            case 2:
                return new SecondStrategyImpl();
            default:
                throw new RuntimeException("类型不匹配");
        }
    }

}
