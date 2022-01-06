package com.thy.exam.service;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.TimeItem;
import com.thy.exam.entity.UserItem;

/**
 * Author: thy
 */
public interface AdminService {
    /**
     * 验证登陆信息
     * */
    ResponseItem<UserItem> checkIdentity(String code, String password);

    /**
     * 修改信息
     * @param code 学生账号
     * @param newPwd 新密码
     * */
    ResponseItem<UserItem> changeInfo(String code, String newPwd);

    /**
     * 设置考试起止时间
     * @param startTime 考试开始时间
     * @param endTime 考试结束时间
     * */
    ResponseItem<TimeItem> setExamTime(String startTime, String endTime);
}
