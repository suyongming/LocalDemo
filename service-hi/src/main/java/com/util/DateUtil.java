package com.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类.
 */
public abstract class DateUtil {

    /**
     * DATE_YYYY_MM_DD.
     */
    public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * DATE_YYYY_MM_DD_HH_MM_SS.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * DATE_YYYYMMDDHHMMSSSSS.
     */
    public static final String DATE_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    /**
     * DATE_YYYYMMDDHHMMSS.
     */
    public static final String DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /**
     * DATE_YYYY_MM_DD_HH_MM.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /**
     * DATE_YYYYMMDD.
     */
    public static final String DATE_YYYYMMDD = "yyyyMMdd";
    /**
     * DATE_HH_MM.
     */
    public static final String DATE_HH_MM = "HH:mm";
    /**
     * DATE_HHMMSSSSS.
     */
    public static final String DATE_HHMMSSSSS = "HHmmssSSS";
    /**
     * YY_MM_DDMMSS.
     */
    public static final String YY_MM_DDMMSS = "yyMMddHHmmss";
    /**
     * ONE_DAY_MILLISENCONDS.
     */
    public static final long ONE_DAY_MILLISENCONDS = 24 * 3600 * 1000;
    /**
     * DATE_YY_MM_DDMMSS.
     */
    public static final String DATE_YY_MM_DDMMSS = "yyyy/MM/dd";

    /**
     * DATE_YYYY_MM_DD_HH_MM_ZH.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM_ZH = "yyyy年MM月dd日 HH:mm";

    /**
     * DATE_YYYY_MM_DD_ZH.
     */
    public static final String DATE_YYYY_MM_DD_ZH = "yyyy年MM月dd日";

    /**
     * DATE_YYYY_MM_DD_HH_MM_SS_SSS.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 解决时区问题.
     */
    public static final ZoneId WECHAT_CN_ZONE_ID = ZoneId.of("Asia/Shanghai");

    /**
     * 9点开始, 包含 9 点.
     */
    private static final LocalTime WECHAT_SELFHELP_OPEN_TIME = LocalTime.of(9, 0, 0);

    /**
     * 21 点结束, 包含 21:0:0 整点.
     */
    private static final LocalTime WECHAT_SELFHELP_CLOSE_TIME = LocalTime.of(21, 0, 0);


    /**
     * date2String.
     */
    public static String date2String(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * string2date.
     */
    public static Date string2date(String dateString, String format) {
        Date retDate = null;
        if (format == null) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            retDate = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return retDate;
    }

    /**
     * getDate.
     */
    public static String getDate(String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    /**
     * 获取时间差.
     *
     * @param date1 日期
     * @param date2 日期
     * @return
     */
    public static BigDecimal differentDaysByMillisecond(Date date1, Date date2) {
        BigDecimal diffTimes = new BigDecimal(date2.getTime()).subtract(new BigDecimal(date1.getTime()));
        return diffTimes.divide(new BigDecimal(DateUtil.ONE_DAY_MILLISENCONDS), 2, RoundingMode.HALF_UP);
    }

    /**
     * 给日期加天数.
     *
     * @param date 日期
     * @param day  天数 + 或 -
     * @return String
     */
    public static String addDate(String date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.string2date(date, DateUtil.DATE_YYYY_MM_DD));
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return DateUtil.date2String(calendar.getTime(), DateUtil.DATE_YYYY_MM_DD);
    }
    
    /**
     * 给日期加年数.
     * @param date 日期
     * @param year  年数 + 或 -
     * @return Date
     */
    public static Date addYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 判断当前时间是否在微信支持时间9：00 - 21：00.
     * @return
     */
    public static boolean isWeChatSelfHelpOpeningNow() {
        LocalTime now = LocalTime.now(WECHAT_CN_ZONE_ID);
        return !now.isBefore(WECHAT_SELFHELP_OPEN_TIME) && !now.isAfter(WECHAT_SELFHELP_CLOSE_TIME);
    }
}
