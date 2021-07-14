package cn.sam.template.commons;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MyNumber {

    public static boolean isNotNumOrNegative(Number num) {
        if (num instanceof Integer) {
            int v = num.intValue();
            return v < 0;
        }
        if (num instanceof Long) {
            long v = num.longValue();
            return v < 0;
        }
        if (num instanceof BigInteger) {
            BigInteger v = (BigInteger) num;
            return v.compareTo(BigInteger.valueOf(0L)) < 0;
        }
        if (num instanceof BigDecimal) {
            BigDecimal v = (BigDecimal) num;
            return v.compareTo(BigDecimal.valueOf(0L)) < 0;
        }
        return false;
    }

}
