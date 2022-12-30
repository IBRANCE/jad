package com.jad.jad.biz.collections;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import com.jad.jad.biz.common.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CollectionsTest {
    
    public static void main(String[] args) {
        // "" null " "
        BigDecimal bigDecimal = new BigDecimal(StringUtils.defaultIfBlank(null, "0"));
        System.out.println("bigDecimal = " + bigDecimal.doubleValue());

        CollectionsTest ct = new CollectionsTest();
        ct.mapTest();


    }

    private void mapTest() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        System.out.println("map.toString() = " + map.toString());
        String mapStr = map.toString();

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader reader = objectMapper.reader();

//
//        Map<String, Object> stringObjectMap = JsonUtil.toMap(mapStr);
//        System.out.println("stringObjectMap = " + stringObjectMap);

    }

}
