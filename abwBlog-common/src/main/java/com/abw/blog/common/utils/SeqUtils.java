package com.abw.blog.common.utils;

import java.util.UUID;

/**
 * Created by fanghuabao on 2018/4/25 0025.
 *
 * 序列生成工具类
 */
public class SeqUtils {

    /**
     * 随机获取UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 带有时间前缀的UUID, 形如: 20180425163025+UUID
     * @return
     */
    public static String getUUIDPreWithTime(){
        return TimeUtils.getCurrTimeStr(TimeUtils.TIME_FORMAT_YYYYMMDDHHMMSS)+getUUID();
    }
}
