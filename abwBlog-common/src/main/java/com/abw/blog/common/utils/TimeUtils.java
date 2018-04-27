package com.abw.blog.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fanghuabao on 2018/4/25 0025.
 */
public class TimeUtils {

    public static final String TIME_FORMAT_YYYYMMDDHHMMSS="yyyyMMddHHmmss";

    /**
     * 获取指定时间格式下 当前时间的字符串
     * @param timeFormat
     * @return
     */
    public static String getCurrTimeStr(String timeFormat){
        return new SimpleDateFormat(timeFormat).format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getCurrTimeStr(TIME_FORMAT_YYYYMMDDHHMMSS));
    }
}
