package com.jad.jad.biz.designpattern.strategy.after;

/**
 * @author nice
 * @date 2022/1/22
 * @desc
 */
public class SecondStrategyImpl implements BaseStrategy {
    @Override
    public void action() {
        System.out.println("这是第二个策略");
    }
}
