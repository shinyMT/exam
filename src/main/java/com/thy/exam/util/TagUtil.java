package com.thy.exam.util;

import java.util.Calendar;

/**
 * Author: thy
 * Date: 2022/1/5 12:28
 * 生成试卷唯一标识符的工具类
 */
public class TagUtil {
    /**
     * 生成唯一标识
     * @param code 教师账号
     * */
    public String generateTag(String code){
        Calendar calendar = Calendar.getInstance();
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(calendar.get(Calendar.MINUTE));
        String second = Integer.toString(calendar.get(Calendar.SECOND));

        // 将教师工号和生成的时间拼接作为唯一标识符返回
//        System.out.println(year + month + day + hour + minute + second);
        return code + "-" + year + month + day + hour + minute + second;
    }
}
