/**
 * 
 */
package com.comdosoft.union.common;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统日期-时间工具类
 * 
 * @author shine
 * 
 */
public class SysDateTimeUtils {

    /**
     * 获取系统当前时间
     * 
     * @return Timestamp
     */
    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取系统当前时间
     * 
     * @return Date
     */
    public static Date nowDate() {
        return new Date();
    }

    /**
     * 获取系统当前时间
     * 
     * @param pattern
     *            yyyy-MM-dd HH:mm:ss SSS / yyyy-MM-dd hh:mm:ss SSS
     * @return
     */
    public static String now(String pattern) {
        return TimestampToString(now(), pattern);
    }

    /**
     * Date时间类型转换成给定格式的时间String
     * 
     * @param date
     * @param pattern
     *            yyyy-MM-dd HH:mm:ss / yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static String DateToString(Date date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Timestamp时间类型转换成给定格式的时间String
     * 
     * @param timestamp
     * @param pattern
     *            yyyy-MM-dd HH:mm:ss / yyyy-MM-dd hh:mm:ss / yyyy-MM-dd hh:mm:ss SSS
     * @return
     */
    public static String TimestampToString(Timestamp timestamp, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.format(timestamp);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Long类型的日期时间转换成给定格式的String
     * 
     * @param longTime
     * @param pattern
     *            yyyy-MM-dd HH:mm:ss / yyyy-MM-dd hh:mm:ss / yyyy-MM-dd hh:mm:ss SSS
     * @return
     */
    public static String longToString(Long longTime, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.format(longTime);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将年份字符串转换成固定格式的日期字符串
     * 
     * @param dateStr
     *            日期字符串 ：必须是yyyy格式
     * @param flg
     *            1代表一年的开始时间;2代表一年的结束时间
     * @return
     * @throws ParseException
     */
    public static String parseYear(String dateStr, int flg) {
        String beginFlg = "01-01 00:00:00";
        String endFlg = "12-31 23:59:59";
        if (1 == flg) {
            dateStr = dateStr + "-" + beginFlg;
        } else if (2 == flg) {
            dateStr = dateStr + "-" + endFlg;
        } else {
            System.err.println("DateTimeTools.parse>>>传递的参数flg异常:" + flg);
        }
        return dateStr;
    }

    /**
     * 将年月字符串转换成固定格式的日期字符串
     * 
     * @param dateStr
     *            日期字符串 ：必须是yyyyMM格式
     * @param flg
     *            1代表一个月的开始时间;2代表一个月的结束时间
     * @return
     * @throws ParseException
     */
    public static String parseYearMonth(String dateStr, int flg) {
        String beginFlg = "01 00:00:00";
        String endFlg = "31 23:59:59";
        if (1 == flg) {
            dateStr = dateStr + "-" + beginFlg;
        } else if (2 == flg) {
            dateStr = dateStr + "-" + endFlg;
        } else {
            System.err.println("DateTimeTools.parse>>>传递的参数flg异常:" + flg);
        }
        return dateStr;
    }

    /**
     * 将String类型的字符串转化为日期类型
     * 
     * @param source
     * @param pattern
     * @return
     */
    public static Date stringToDate(String dateStr, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将""的日期字符串字段值转换为null
     * 
     * @param object
     */
    public static void emptyDateStrConvertToNull(Object object) {
        Class<?> c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().equals(String.class) && (field.getName().endsWith("DateStr") || field.getName().endsWith("TimeStr"))) {
                field.setAccessible(true);
                try {
                    if ("".equals(field.get(object))) {
                        field.set(object, null);
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("\"\"的日期字符串转换为null异常");
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    System.err.println("\"\"的日期字符串转换为null异常");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试主方法入口
     * 
     * @param args
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws ParseException
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

        System.out.println(parseYearMonth("20140723", 1));

    }
}