package me.kevin.time;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @author Kevin
 * @description
 * @date 2017/1/19
 */
public class Dates {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前日期对象
     *
     * @return 当前日期对象
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 获取当前日期字符串
     *
     * @param format 日期格式
     * @return 当前日期字符串
     */
    public static String now(String format) {
        return format(now(), format);
    }

    /**
     * 格式化日期对象 默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期对象
     * @return 当前日期字符串
     */
    public static String format(Date date) {
        return format(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 格式化日期对象 默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @param millis 毫秒
     * @return 日期字符串
     */
    public static String format(long millis) {
        return format(millis, DEFAULT_DATE_FORMAT);
    }

    /**
     * 格式化日期对象 默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @param millis 毫秒
     * @param format 日期格式
     * @return 日期字符串
     */
    public static String format(long millis, String format) {
        return new DateTime(millis).toString(format);
    }

    /**
     * 格式化日期对象
     *
     * @param date   日期对象
     * @param format 日期格式
     * @return 当前日期字符串
     */
    public static String format(Date date, String format) {
        return new DateTime(date).toString(format);
    }

    /**
     * 转换日期字符串为日期对象(默认格式：yyyy-MM-dd HH:mm:ss)
     *
     * @param dateStr 日期字符串
     * @return 日期对象
     */
    public static Date toDate(String dateStr) {
        return toDate(dateStr, DEFAULT_DATE_FORMAT);
    }

    /**
     * 转换日期字符串为指定格式日期对象
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return
     */
    public static Date toDate(String dateStr, String format) {
        return DateTimeFormat.forPattern(format).parseDateTime(dateStr).toDate();
    }

    /**
     * 毫秒转date对象
     *
     * @param millis
     * @return
     */
    public static Date toDate(long millis) {
        return new DateTime(millis).toDate();
    }

    /**
     * 计算两个日期的时间差(单位：秒)
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 时间间隔
     */
    public static long timeInterval(Date startTime, Date endTime) {
        long start = startTime.getTime();
        long end = endTime.getTime();
        return (end - start) / 1000;
    }

    /**
     * 获取指定日期当天的开始时间
     *
     * @param date 日期
     * @return 时间
     */
    public static Date startOfDay(Date date) {
        return new DateTime(date).withTimeAtStartOfDay().toDate();
    }

    /**
     * 获取指定日期当天的结束时间
     *
     * @param date 日期
     * @return 时间
     */
    public static Date endOfDay(Date date) {
        return new DateTime(date).millisOfDay().withMaximumValue().toDate();
    }

    /**
     * 获取本月第几天日期对象
     *
     * @param day 1:第一天，2:第二天，...
     * @return 本月第几天日期对象
     */
    public static Date dayOfMonth(Integer day) {
        return new DateTime(DateTime.now().toString("yyyy-MM-dd")).withDayOfMonth(day).toDate();
    }

    /**
     * 获取本年第几天日期对象
     *
     * @param day 1:第一天，2:第二天，...
     * @return 本年第几天日期对象
     */
    public static Date dayOfYear(Integer day) {
        return new DateTime(DateTime.now().toString("yyyy-MM-dd")).withDayOfYear(day).toDate();
    }

    /**
     * 增加分钟
     *
     * @param date         时间
     * @param numOfMinutes 分钟数
     * @return 时间
     */
    public static Date addMinutes(Date date, int numOfMinutes) {
        return new DateTime(date).plusMillis(numOfMinutes).toDate();
    }

    /**
     * 增加小时
     *
     * @param date       时间
     * @param numOfHours 小时数
     * @return 时间
     */
    public static Date addHours(Date date, int numOfHours) {
        return new DateTime(date).plusHours(numOfHours).toDate();
    }

    /**
     * 增加天数
     *
     * @param date    时间
     * @param numdays 天数
     * @return 时间
     */
    public static Date addDays(Date date, int numdays) {
        return new DateTime(date).plusDays(numdays).toDate();
    }

    /**
     * 增加周
     *
     * @param date     时间
     * @param numWeeks 周数
     * @return 时间
     */
    public static Date addWeeks(Date date, int numWeeks) {
        return new DateTime(date).plusWeeks(numWeeks).toDate();
    }

    /**
     * 增加月份
     *
     * @param date      时间
     * @param numMonths 月数
     * @return 时间
     */
    public static Date addMonths(Date date, int numMonths) {
        return new DateTime(date).plusMonths(numMonths).toDate();
    }

    /**
     * 增加年
     *
     * @param date     时间
     * @param numYears 年数
     * @return 时间
     */
    public static Date addYears(Date date, int numYears) {
        return new DateTime(date).plusYears(numYears).toDate();
    }

    /**
     * 日期a是否大于日期b
     *
     * @param a 日期a
     * @param b 日期b
     * @return 大于返回true，反之false
     */
    public static boolean isAfter(Date a, Date b) {
        return new DateTime(a).isAfter(b.getTime());
    }

    /**
     * 日期a是否大于当前日期
     *
     * @param date 比较日期
     * @return 是否大于当前日期
     */
    public static boolean isAfterNow(Date date) {
        return new DateTime(date).isAfterNow();
    }

    /**
     * 日期a是否小于日期b
     *
     * @param a 日期a
     * @param b 日期b
     * @return 小于返回true，反之false
     */
    public static Boolean isBefore(Date a, Date b) {
        return new DateTime(a).isBefore(b.getTime());
    }

    /**
     * 日期a是否大于当前日期
     *
     * @param date 日期a
     * @return 小于返回true，反之false
     */
    public static Boolean isBefore(Date date) {
        return new DateTime(date).isBeforeNow();
    }

    /**
     * 获得当前月的第一天
     *
     * @param date 日期
     * @return 当前月的第一天
     */
    public static Date startDateOfMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().withMinimumValue().toDate();
    }

    /**
     * 获得当前月的最后一天
     *
     * @param date 日期
     * @return 当前月的最后一天
     */
    public static Date endDateOfMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().withMaximumValue().toDate();
    }

    /**
     * 获得当前周第一天,周一
     *
     * @param date 日期
     * @return 当前周第一天
     */
    public static Date startDateOfWeek(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfWeek().withMinimumValue().toDate();
    }

    /**
     * 获得当前周最后一天 周日
     *
     * @param date 日期
     * @return 当前周最后一天
     */
    public static Date endDateOfWeek(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfWeek().withMaximumValue().toDate();
    }

    public static boolean isBetween(Date date, Date start, Date end) {
        if (date == null || start == null || end == null || start.after(end)) {
            throw new IllegalArgumentException("some date parameters is null or dateBein after dateEnd");
        }
        return !date.before(start) && !date.after(end);
    }
}
