package com.jad.jad.biz.common.util;

import java.math.BigDecimal;

/**
 * BigDecimalUtil 安全的创建BigDecimal对象，防止出现异常
 */
public class BigDecimalUtil {

    public static final String ZERO_STR = "0";

    public static BigDecimal newInstance(String origin) {
        return new BigDecimal(StringUtil.defaultIfBlank(origin, ZERO_STR));
    }

}
