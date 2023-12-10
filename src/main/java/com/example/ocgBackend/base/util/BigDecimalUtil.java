package com.example.ocgBackend.base.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
    public static BigDecimal getBigDecimal(Long value) {
        if(value != null) {
            return BigDecimal.valueOf(value);
        }else {
            return null;
        }
    }
    public static BigDecimal getBigDecimal(Integer value) {
        if(value != null) {
            return BigDecimal.valueOf(value);
        }else {
            return null;
        }
    }
}
