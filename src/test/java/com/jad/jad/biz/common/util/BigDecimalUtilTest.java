package com.jad.jad.biz.common.util;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;


public class BigDecimalUtilTest {

    @Test
    public void test00() {
        BigDecimal bigDecimal = BigDecimalUtil.newInstance("");
        System.out.println("bigDecimal = " + bigDecimal);
    }

    @Test
    public void test01() {
        BigDecimal bigDecimal = BigDecimalUtil.newInstance(null);
        System.out.println("bigDecimal = " + bigDecimal);
    }

    @Test
    public void test02() {
        BigDecimal bigDecimal = BigDecimalUtil.newInstance(" ");
        System.out.println("bigDecimal = " + bigDecimal);
    }

}