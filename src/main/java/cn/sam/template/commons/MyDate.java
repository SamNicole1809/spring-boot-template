package cn.sam.template.commons;

import cn.sam.template.constant.MyConstant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {

    public static Date getOneHourLater() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        return calendar.getTime();
    }

    public static long getCurrentStamp() {
        return System.currentTimeMillis();
    }

    public static String timestamp2DateString(Long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(MyConstant.FORMAT_DATE);
        return sdf.format(new Date(timestamp));
    }

    public static String timestamp2DatetimeString(Long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(MyConstant.FORMAT_DATETIME);
        return sdf.format(new Date(timestamp));
    }

}
