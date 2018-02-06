package com.clawhub.test.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * <Description>LocalDateTime工具类 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年1月10日 <br>
 */
public class LocalDateTimeUtils {

    /**
     * 999999999 <br>
     */
    public static final int NINE_NINE = 999999999;

    /**
     * 一天的毫秒数 <br>
     */
    public static final long ONE_DAYS_MILLI = 24 * 60 * 60 * 1000L;

    /**
     * 私有构造
     */
    private LocalDateTimeUtils() {

    }

    /**
     * Description: Date转换为LocalDateTime<br>
     *
     * @param date Date类型时间
     * @return LocalDateTime类型时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Description:LocalDateTime转换为Date <br>
     *
     * @param time LocalDateTime类型时间
     * @return Date类型时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Description:指定日期的毫秒转LocalDateTime <br>
     *
     * @param milli 日期毫秒数
     * @return LocalDateTime类型时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static LocalDateTime getTimeByMilli(Long milli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(milli), ZoneId.systemDefault());
    }

    /**
     * Description:获取指定日期的毫秒 <br>
     *
     * @param time LocalDateTime类型时间
     * @return 毫秒数<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * Description:获取指定日期的秒 <br>
     *
     * @param time LocalDateTime类型时间
     * @return 秒数<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * Description: 获取指定时间的指定格式<br>
     *
     * @param time    LocalDateTime类型时间
     * @param pattern 时间格式
     * @return 格式化后的时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Description:获取当前时间的指定格式 <br>
     *
     * @param pattern 时间格式
     * @return 格式化后时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * Description: 日期加上一个数,根据field不同加不同值,field为ChronoUnit.* <br>
     *
     * @param time   LocalDateTime类型时间
     * @param number 要增加的数字
     * @param field  单位(年月日时分秒)
     * @return LocalDateTime类型时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * Description: 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*<br>
     *
     * @param time   LocalDateTime类型时间
     * @param number 要减少的数字
     * @param field  单位(年月日时分秒)
     * @return LocalDateTime类型时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * Description: 获取两个日期的差 field参数为ChronoUnit.*<br>
     *
     * @param startTime LocalDateTime格式开始时间
     * @param endTime   LocalDateTime格式结束时间
     * @param field     单位(年月日时分秒)
     * @return 差值<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return (long) (period.getYears() * 12 + period.getMonths());
        }
        return field.between(startTime, endTime);
    }

    /**
     * Description: 计算两个时间之间相隔天数，不足一天算一天<br>
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static Long betweenTwoTimeOfDays(Long start, Long end) {
        // 时间间隔
        Long timeSlot = end - start;
        // 除
        Long days = timeSlot / ONE_DAYS_MILLI;
        // 取模
        Long modul = timeSlot % ONE_DAYS_MILLI;

        if (modul > 0) {
            days++;
        }
        return days;
    }

    /**
     * Description:获取一天的开始时间，2018,1,10 00:00:00.000000000 <br>
     *
     * @param time LocalDateTime格式时间
     * @return LocalDateTime格式时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * Description:获取一天的结束时间，2018,1,10 23:59:59.999999999 <br>
     *
     * @param time LocalDateTime格式时间
     * @return LocalDateTime格式时间<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(NINE_NINE);
    }

    /**
     * Description: 获取某一天结束时间的毫秒数<br>
     *
     * @param milli 毫秒数
     * @return 毫秒数<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static long getDayEndMilli(long milli) {
        return getMilliByTime(getDayEnd(getTimeByMilli(milli)));
    }

    /**
     * Description: 获取某一天开始时间的毫秒数<br>
     *
     * @param milli 毫秒数
     * @return 毫秒数<br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static long getDayStartMilli(long milli) {
        return getMilliByTime(getDayStart(getTimeByMilli(milli)));
    }

}
