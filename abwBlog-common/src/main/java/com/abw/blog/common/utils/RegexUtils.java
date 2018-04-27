package com.abw.blog.common.utils;

/**
 * Created by fanghuabao on 2018/4/27 0027.
 */
public class RegexUtils {


    /**
     *
     * @param val   被校验值
     * @param regex 正则表达式
     * @return
     */
    public static boolean isMatch(String val,String regex){
        return val.matches(regex);
    }


    public static void main(String[] args) {
        String regex = "([A-Za-z0-9]+=[A-Za-z0-9]*\\|)*[A-Za-z0-9]+=[A-Za-z0-9]*";
        String val = "msg=hello";
        System.out.println(RegexUtils.isMatch(val,regex));
    }

}
