package com.thy.exam.sql;

import org.apache.ibatis.jdbc.SQL;

/**
 * Author: thy
 */
public class AdminSql {
    private static final String USER_TABLE = "user";
    private static final String TIME_TABLE = "time";

    /**
     * 验证用户登陆信息
     * */
    public String checkIdentity(String code){
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM(USER_TABLE);
        sql.WHERE("code='" + code + "'");

        return sql.toString();
    }

    /**
     * 修改用户信息
     * @param code 账号
     * @param newPwd 新密码
     * */
    public String changeInfo(String code, String newPwd){
        SQL sql = new SQL();
        sql.UPDATE(USER_TABLE);
        sql.SET("password='" + newPwd + "'");
        sql.WHERE("code='" + code + "'");

        return sql.toString();
    }

    /**
     * 设置考试起止时间
     * @param startTime 开始时间
     * @param endTime 截止时间
     * */
    public String setExamTime(String startTime, String endTime){
        SQL sql = new SQL();
        sql.UPDATE(TIME_TABLE);
        sql.SET("startTime='" + startTime + "', endTime='" + endTime + "'");

        return sql.toString();
    }
}
