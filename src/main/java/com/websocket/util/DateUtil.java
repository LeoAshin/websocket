package com.websocket.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tammy on 2016/5/28.
 */
public class DateUtil {
    /**
     * 获取当前时间
     *
     * @param dateFormat 时间格式
     * @return
     */
    public static String currentDate(String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        String date = df.format(new Date());
        return date;
    }

    public static String curToTimestamp() {
        Date date = new Date();
        Long times = date.getTime();
        return times.toString();
    }

    public static String changeDate(String date,String dateFormat) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar cal = Calendar.getInstance();
        Date dt = null;
        dt = formatter.parse(date);
        cal.setTime(dt);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String montnS="";
        String dayS="";
        if(month<10){
            montnS=String.valueOf(0)+String.valueOf(month);
        }else {
            montnS=String.valueOf(month);
        }
        if(day<10){
            dayS=String.valueOf(0)+String.valueOf(day);
        }else {
            dayS=String.valueOf(day);
        }
        return String.valueOf(year)+montnS+dayS;
    }

   //获取当前时间指定前几天的日期
    public static String preCur(String format, Integer days) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -days);
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        return preMonday;
    }
    /**
     * 获取指定时间指定后几天的日期
     *
     * @param format
     * @param days
     * @return
     */
    public static String afterDate(String date, String format, Integer days) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToDate(date, format));
        calendar.add(Calendar.DATE, +days);
        Date d = calendar.getTime();
        return sdf.format(d);
    }
    //两个日期相差天数
    public static int daysOfTwo(String fDate, String oDate, String format) {

        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(stringToDate(fDate, format));
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(stringToDate(oDate, format));
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        return Math.abs(day2 - day1 + 1);

    }

    /**
     * 将字符串转为时间戳
     *
     * @param user_time
     * @return
     */
    public static String dateToTimestamp(String user_time, String dateFormat) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date d;
        try {
            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }


    /**
     * 将字符串转为时间戳(秒)
     *
     * @param user_time
     * @return
     */
    public static String dateToTimeSecstamp(String user_time, String dateFormat) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date d;
        try {
            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }


    /**
     * 将字符串转为时间戳
     *
     * @param date
     * @return
     */
    public static String dateToTimestamp(Date date, String dateFormat) {
        long l = date.getTime();
        String str = String.valueOf(l);
        return str;
    }

    /**
     * 时间戳转换为dateFormat
     *
     * @param date
     * @return
     */
    public static String timestampToDate(String date, String format) {
        int length = date.length();
        if (length == 10) {
            date += "000";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String sd = sdf.format(new Date(Long.parseLong(date)));
        return sd;
    }

    /**
     * 字符串转换为时间
     *
     * @param date
     * @param format
     * @return
     */
    public static Date stringToDate(String date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date time = null;
        try {
            time = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 时间转字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        String dateS = (new SimpleDateFormat(format)).format(date);
        return dateS;
    }

    /**
     * 判断时间是否在区间内
     *
     * @param date
     * @param dateAfter
     * @param dateBefore
     * @return
     */
    public static boolean judge(Date date, Date dateAfter, Date dateBefore) {
        boolean bool = true;
        if (date.before(dateAfter) && date.after(dateBefore)) {
            return bool;
        } else {
            bool = false;
            return bool;
        }
    }

    /**
     * 获取两个时间的时间差（毫秒）
     * (想要秒自个除1000去)
     *
     * @param dateAfter
     * @param dateBefore
     * @param format
     * @return
     */
    public static long timeDiff(String dateBefore, String dateAfter, String format) {
        Date d1 = (Date) stringToDate(dateBefore, format);
        Date d2 = (Date) stringToDate(dateAfter, format);
        long time = d2.getTime() - d1.getTime();
        return time;
    }

    /**
     * 获取两个时间的时间差（分钟）
     * (想要秒自个除1000去)
     *
     * @param dateAfter
     * @param dateBefore
     * @param format
     * @return
     */
    public static long timeDiffMin(String dateBefore, String dateAfter, String format) {
        Date d1 = (Date) stringToDate(dateBefore, format);
        Date d2 = (Date) stringToDate(dateAfter, format);
        long time = d2.getTime() - d1.getTime();
        return time / (1000 * 60);
    }

    /**
     * h获取与当前时间的时间差（毫秒）
     *
     * @param curDate
     * @param date
     * @param format
     * @return
     */
    public static long timeDiff(Date curDate, String date, String format) {
        Date d1 = (Date) stringToDate(date, format);
        long time = curDate.getTime() - d1.getTime();
        return time;
    }

    public static long getTimestamp(String time, String format) {
        long result = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date date = df.parse(time);
            result = date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据出生年月计算年龄
     *
     * @param date
     * @param format
     * @return
     */
    public static long userAge(String date, String format) {
//        Date now = new Date();
//        long num = timeDiff(now, date, format);
//        long year = num / (1000 * 60 * 60 * 24 * 365);
//        return year;
        Date birthday = stringToDate(date, CommonConst.DATEFORMAT1);
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }


    public static String addStampByDays(String stamp, String days) {
        Long time = Long.parseLong(stamp);
        Long res = time + Integer.parseInt(days) * 24 * 60 * 60 * 1000;
        return res.toString();
    }


    /**
     * 判断某时间是否在两个时间内 0；是，1：大于，-1：小于
     *
     * @param small 时间短中较小的时间
     * @param big   时间短中较大的时间
     * @param cur   要比较的时间
     * @return
     */
    public static Integer inInterval(Long small, Long big, Long cur) {
        if (small > cur) {
            return -1;
        } else if (cur > big) {
            return 1;
        } else {
            return 0;
        }
    }

    public static Long addStampByHours(String stamp, String hours) {
        Long time = Long.parseLong(stamp);
        Long res = time + Integer.parseInt(hours) * 60 * 60 * 1000;
        return res;
    }


    public static Long addStampByMins(String stamp, String minutes) {
        Long time = Long.parseLong(stamp);
        Long res = time + Integer.parseInt(minutes) * 60 * 1000;
        return res;
    }


    public static String y4M2d2H2m2s2(String date, String hhmm) {
        return date + CommonConst.BLANKSPACE + hhmm + ":00";
    }

    public static String hhmm(String date) {
        return date.substring(11, 16);
    }

    public static String toDate(String dateTime) {
        String date = "";
        if (dateTime.length() >= 10) {
            date = dateTime.substring(0, 10);
        }
        return date;
    }

    public static void main(String[] args) throws ParseException {
//        String date = "2016-06-28 16:00:00";
//        System.out.println(timeDiff(currentDate(CommonConst.DATEFORMAT3), date, CommonConst.DATEFORMAT3));
//        System.out.println(dateToTimestamp(new Date(),CommonConst.DATEFORMAT3));
//        System.out.println(System.currentTimeMillis());

//        System.out.println(dateToTimestamp(currentDate(CommonConst.DATEFORMAT3),CommonConst.DATEFORMAT3));
//        System.out.println(curToTimestamp());
//        System.out.println(dateToTimestamp(currentDate(CommonConst.DATEFORMAT4), CommonConst.DATEFORMAT4));
//        System.out.println(currentDate(CommonConst.DATEFORMAT4));
//        System.out.println(DateUtil.dateToTimestamp(new Date(), CommonConst.DATEFORMAT3));
//        System.out.println(timestampToDate("1403166586000", CommonConst.DATEFORMAT3));
//        System.out.println(userAge("1992-7-1", CommonConst.DATEFORMAT3));
//        System.out.println(dateToTimestamp("2016-7-13 20:18:00", CommonConst.DATEFORMAT3));
//        System.out.println(dateToTimestamp("2016-8-13 20:18:00", CommonConst.DATEFORMAT3));
//        System.out.println(addStampByDays("1468412280", "31"));
//        System.out.println(toDate(date));
//        System.out.println(preCur(CommonConst.DATEFORMAT4,14));
//        System.out.println(afterDate("20161104",CommonConst.DATEFORMAT4,1));
        System.out.println(changeDate("2016-01-24",CommonConst.DATEFORMAT1));
    }
}
