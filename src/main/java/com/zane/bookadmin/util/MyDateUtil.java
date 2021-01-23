package com.zane.bookadmin.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MyDateUtil {
    /**
     * 获取最近三个月的最后一天
     */
    public static List<String> getRecent3MonthsLastDay() {
        List<String> months = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -3);
        for (int i = 0; i < 3; i++) {
            c.add(Calendar.MONTH, 1);
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            months.add(format.format(c.getTime()));
        }
        return months;
    }

    /**
     * 获取本月最后一天
     */
    public static String getCurrentMonthLastDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(c.getTime());
    }
    /**
     * 获取本月第一天
     */
    public static String getCurrentMonthFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(c.getTime());
    }
}
