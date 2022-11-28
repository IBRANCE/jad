package com.jad.jad.biz.designpattern.strategy.after;

/**
 * @author nice
 * @date 2022/1/22
 * @desc
 */
public class FirstStrategyImpl implements BaseStrategy{

    @Override
    public void action() {
        System.out.println("这个是第一个策略");
    }
}
