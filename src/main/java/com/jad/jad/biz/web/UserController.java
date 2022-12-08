package com.jad.jad.biz.web;

import com.jad.jad.biz.common.util.RateLimitUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RateLimitUtil rateLimitUtil;

    @PostMapping("/get")
    public String get() {
        if (rateLimitUtil.tryLimit()) {
            System.out.println("执行业务逻辑 GET方法");
        } else {
            System.out.println("流控中，不能进行操作");
        }
        return "hello";
    }

    @PostMapping("/body/test")
    public void testBody(@RequestBody Map<String, String> map) {
        System.out.println("map = " + map);
    }

}
