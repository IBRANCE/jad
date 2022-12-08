package com.jad.jad.biz.common.util;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用redis实现限流控制算法
 * 令牌桶算法：
 *  1个线程按照指定的频率生产令牌，并放到桶中。
 *  消费线程先从桶中获取令牌，能获取到，则继续执行，不然就返回。
 */

@Component
public class RateLimitUtil {

    private static final Logger logger = LoggerFactory.getLogger(RateLimitUtil.class);

    @Autowired
    private RedisTemplate<String, String> rt;

    private static final String RATE_LIMIT_VAL = "RATE_LIMIT_VAL";

    private static final String RATE_LIMIT_LOCK = "RATE_LIMIT_LOCK";

    /**
     * tps
     */
    private static final int rate = 1;

    /**
     * 假设这就是令牌
     */
    private static final AtomicInteger atomicInt = new AtomicInteger(rate);

//    @PostConstruct
//    public void init() {
//        // 启动一个定时线程，向redis中写入数据.
//        // FIXME: 2022/12/1 假设每个部署节点都有一个定时线程，如果同时向redis中写入数据，则有可能出现redis中的数据一直更新的情况
//        Executors.newScheduledThreadPool(4).scheduleAtFixedRate(() -> {
//            // 初始化为1，可以先获取一个分布式锁，然后在更新值
//            if (Boolean.TRUE.equals(rt.opsForValue().setIfAbsent(RATE_LIMIT_LOCK, "1", Duration.ofMillis(200)))) {
//                rt.opsForValue().set(RATE_LIMIT_VAL, String.valueOf(rate));
//            } else {
//                logger.info("没有获取到锁，无法执行修改操作...");
//            }
////            rt.opsForValue().getAndDelete(RATE_LIMIT_LOCK);
//        }, 0, 1, TimeUnit.SECONDS);
//    }

    /**
     * 判断是否达到了流控值
     * 使用计数法 + redis的incr方法来达成。
     * 优点：实现简单
     * 缺点：边界问题，
     *
     * @return true-可以访问 false-不可以访问
     */
    public boolean tryLimit() {
        // 获取实际的流控值
        Long val = rt.opsForValue().increment(RATE_LIMIT_VAL);
        if (val == 1) {
            rt.expire(RATE_LIMIT_VAL, 1, TimeUnit.MINUTES);
        }
        if (val > 20) {
            return false;
        }
        return true;
    }

}
