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
}
