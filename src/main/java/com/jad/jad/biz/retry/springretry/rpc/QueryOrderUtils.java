package com.jad.jad.biz.retry.springretry.rpc;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 调用外部接口查询订单
 */
@Component
public class QueryOrderUtils {

    private static final Logger logger = LoggerFactory.getLogger(QueryOrderUtils.class);

    int count = 0;

    @Retryable(retryFor = Exception.class, maxAttempts = 4)
    public List<String> queryOrders() {
        count += 1;
        if (count < 3) {
            logger.info("exec {} times, occur error", count);
            throw new RuntimeException("发生异常");
        }
        logger.info("exec success process");
        return Lists.newArrayList("1", "2", "3");
    }

}
