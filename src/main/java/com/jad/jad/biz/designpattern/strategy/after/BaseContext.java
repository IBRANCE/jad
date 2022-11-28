package com.jad.jad.biz.designpattern.strategy.after;

/**
 * @author nice
 * @date 2022/1/23
 * @desc 策略的上下文对象，持有具体的策略
 */
public class BaseContext {

    private BaseStrategy baseStrategy;

    public BaseContext(int num) {
        switch (num) {
            case 1:
                this.baseStrategy = new FirstStrategyImpl();
            default:
                this.baseStrategy = new SecondStrategyImpl();
        }
    }

    public void doing() {
        baseStrategy.action();
    }

}
