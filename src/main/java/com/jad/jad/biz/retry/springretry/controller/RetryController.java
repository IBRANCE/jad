package com.jad.jad.biz.retry.springretry.controller;

import com.jad.jad.biz.retry.springretry.rpc.QueryOrderUtils;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nice
 * @create 2022/1/20 3:10 下午
 * @desc
 */
@RestController
@RequestMapping("/retry")
public class RetryController {

    private static final Logger logger = LoggerFactory.getLogger(RetryController.class);

    @Resource
    private QueryOrderUtils queryOrderUtils;

    @GetMapping("/get")
    public void queryOrder() {
        queryOrderUtils.queryOrders().stream().forEach(System.out::println);
    }




}
