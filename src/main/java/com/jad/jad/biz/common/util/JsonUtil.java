package com.jad.jad.biz.common.util;

import com.alibaba.fastjson2.JSON;

import java.util.Map;

/**
 * 操作Json的工具类
 */
public class JsonUtil {


    public static Map<String, Object> toMap(String jsonStr) {
        return JSON.parseObject(jsonStr, Map.class);
    }



}
