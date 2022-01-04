package com.thy.exam.service;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.TimeItem;
import com.thy.exam.entity.UserItem;

/**
 * Author: thy
 * Date: 2022/1/4 14:05
 */
public interface AdminService {
    /**
     * 修改信息
     * */
    ResponseItem<UserItem> changeInfo(String code, String newPwd);

    /**
     * 设置考试起止时间
     * */
    ResponseItem<TimeItem> setExamTime(String startTime, String endTime);
}
