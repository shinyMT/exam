package com.thy.exam.dao;

import com.thy.exam.entity.UserItem;
import com.thy.exam.sql.AdminSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * Author: thy
 * Date: 2022/1/4 14:04
 */
@Mapper
public interface AdminDao {
    /**
     * 登陆
     * */
    @SelectProvider(type = AdminSql.class, method = "checkIdentity")
    UserItem checkIdentity(String code);

    /**
     * 修改用户信息
     * */
    @UpdateProvider(type = AdminSql.class, method = "changeInfo")
    Integer changeInfo(String code, String newPwd);

    /**
     * 设置考试起止时间
     * */
    @UpdateProvider(type = AdminSql.class, method = "setExamTime")
    Integer setExamTime(String startTime, String endTime);
}
