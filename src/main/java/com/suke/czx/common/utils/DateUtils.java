package com.suke.czx.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateUtils extends org.apache.commons.lang.time.DateUtils{
    // public  static final  DateTimeFormatter DATE_FORMAT = new DateTimeFormatter  ("yyyy-MM-dd HH:mm:sss");

    public static final String[] DATE_FORMAT_ARRAY = new String[] { "yyyyMMdd", "yyyy-MM-dd", "yyyy年MM月dd日" };
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String dispaly(long timeM){
        return  DateUtils.format(new Date(timeM),"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 判断字符串是否为日期格式
     */
    public static boolean isDate(String dateString)
    {
        if (org.apache.commons.lang3.StringUtils.isEmpty(dateString))
            return false;

        try
        {
            if (!NumberUtils.isNumber(dateString))
            {
                parseDate(dateString, DATE_FORMAT_ARRAY);
                return true;
            }

            BigDecimal bigDecimal = new BigDecimal(dateString);
            parseDate(String.format("%d", bigDecimal.longValue()), DATE_FORMAT_ARRAY);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 判断字符串是否为约定的日期格式
     */
    public static boolean isDate(String dateString, String parsePattern)
    {
        return parseDate(dateString, parsePattern) != null;
    }

    /**
     * 将字符串转为日期
     */
    public static Date parseDate(String dateString, String parsePattern)
    {
        try
        {
            return parseDate(dateString, new String[] { parsePattern });
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 从身份证号中获取出生日期
     */
    public static String parseDateStringFromIdNo(String idNo, String split)
    {
        if (org.apache.commons.lang3.StringUtils.isEmpty(idNo))
            return org.apache.commons.lang3.StringUtils.EMPTY;

        try
        {
            String year = org.apache.commons.lang3.StringUtils.substring(idNo, 6, 10);
            String month = org.apache.commons.lang3.StringUtils.substring(idNo, 10, 12);
            String day = org.apache.commons.lang3.StringUtils.substring(idNo, 12, 14);

            return String.format("%s%s%s%s%s", year, split, month, split, day);
        }
        catch (Exception e)
        {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
    }

    /**
     * 格式化日期
     */
    public static String format(Date date, String format)
    {
        try
        {
            return new SimpleDateFormat(format).format(date);
        }
        catch (Exception e)
        {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
    }

    public static String format(ZonedDateTime date, String format)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        try
        {

            return  date.format(formatter);
        }
        catch (Exception e)
        {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
    }

    /**
     * 将日期字符串转为普通字符串
     */
    public static String toDateTimeString(String dateString)
    {
        if (org.apache.commons.lang3.StringUtils.isEmpty(dateString))
            return StringUtils.EMPTY;

        try
        {
            if (!NumberUtils.isNumber(dateString))
                return dateString;

            BigDecimal bigDecimal = new BigDecimal(dateString);
            return String.format("%d", bigDecimal.longValue());
        }
        catch (Exception e)
        {
            return dateString;
        }
    }

    /**
     * 格式化当前日期
     */
    public static String currentTime(String formatString)
    {
        DateFormat dateFormat = new SimpleDateFormat(formatString);
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    /**
     * 获取两个日期之间的年份差
     */
    public static int yearsBetween(Date greater, Date smaller)
    {
        if (greater == null || smaller == null)
            return 0;

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(greater);
        int greaterYear = calendar.get(Calendar.YEAR);

        calendar.setTime(smaller);
        int littleYear = calendar.get(Calendar.YEAR);

        return greaterYear - littleYear;
    }


    /**
     * 获取两个日期之间的日期差
     */
    public static int daysBetween(Date greater, Date smaller)
    {
        if (greater == null || smaller == null)
            return 0;

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(greater);
        long greaterTimeInMillis = calendar.getTimeInMillis();

        calendar.setTime(smaller);
        long littleTimeInMillis = calendar.getTimeInMillis();

        long dayTimeInMillis = 24 * 60 * 60 * 1000;
        return (int)Math.ceil((double)(greaterTimeInMillis - littleTimeInMillis) / dayTimeInMillis);
    }

    /**
     * 获取两个日期之间的小时差
     * @Title: hoursBetween
     * @Description:
     * @author yong.wang
     * @date 2017-7-14 下午04:38:26
     * @param greater
     * @param smaller
     * @return
     * @return long
     */
    public static long hoursBetween(Date greater, Date smaller)
    {
        if (greater == null || smaller == null)
            return 0L;

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(greater);
        long greaterTimeInMillis = calendar.getTimeInMillis();

        calendar.setTime(smaller);
        long littleTimeInMillis = calendar.getTimeInMillis();

        long hourTimeInMillis = 60 * 60 * 1000;
        return (int)Math.floor((double)(greaterTimeInMillis - littleTimeInMillis) / hourTimeInMillis);
    }

    public static void main(String[] args){
        System.out.println(format(new Date(1517846400000L),"yyyyMMdd HH:mm:ss"));
        Date start = DateUtils.parseDate("2018-01-20 07:10:00", "yyyy-MM-dd HH:mm:ss");

        System.out.println(start.getTime() );
    }


}

