package com.jad.jad.biz.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 测试将对象放到redis中
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private static List<AdDO> data = Lists.newArrayList();

    private static final String cacheKey = "cache_hash_test";

    static {
        AdDO adDo = new AdDO();
        adDo.setId(1L);
        adDo.setName("zs");
        adDo.setVal("1zs");

        for (int i = 0; i < 100; i++) {
            adDo.setVal(i + "curr");
            data.add(AdDO.convert(adDo));
        }

    }

    @PostMapping("/set")
    public void set() {
        int i = 0;
        for (AdDO adDo : data) {
            // 将对象放到map中
            redisTemplate.opsForHash().putAll(cacheKey + i, adDo.toMap());
            redisTemplate.expire(cacheKey + i, 5 + random(), TimeUnit.MINUTES);
            i ++;
        }
    }

    @PostMapping("/get")
    public void get() {
        for (int i = 0; i < 100; i++) {
            // 批量获取map的值
            List<Object> list = redisTemplate.opsForHash().multiGet(cacheKey + i, Lists.newArrayList("id", "name", "val"));
            for (Object o : list) {
                System.out.println("o = " + o);
            }
        }
    }

    /*===================================将对象转换为json字符串，再放到redis中===================================*/

    @GetMapping("/setJson")
    public void setJson() {
        // 将对象转换成json
    }

    @GetMapping("/getJson")
    public void getJson() {

    }


    private int random() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static void main(String[] args) {
        var con = new CacheController();
        for (int i = 0; i < 1000; i++) {
            System.out.println("con = " + con.random());
        }
    }

    @Data
    private static class AdDO {

        private Long id;

        private String name;

        private String val;

        static AdDO convert(AdDO adDO) {
            AdDO res = new AdDO();
            res.id = adDO.id;
            res.name = adDO.name;
            res.val = adDO.val;
            return res;
        }

        Map<String, Object> toMap() {
            Map<String, Object> res = Maps.newHashMap();
            res.put("id", id + "");
            res.put("name", name);
            res.put("val", val);
            return res;
        }

    }

}
