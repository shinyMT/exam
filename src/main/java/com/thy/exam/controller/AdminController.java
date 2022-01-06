package com.thy.exam.controller;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.TimeItem;
import com.thy.exam.entity.UserItem;
import com.thy.exam.service.AdminService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: thy
 */
@RestController
@NoArgsConstructor
public class AdminController {
    private AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService){
        this.adminService = adminService;
    }

    /**
     * 验证用户身份信息
     * */
    @PostMapping("/login")
    public ResponseItem<UserItem> checkIdentity(String code, String password){
        return adminService.checkIdentity(code, password);
    }

    /**
     * 修改用户信息
     * */
    @GetMapping("/change")
    public ResponseItem<UserItem> changeInfo(String code, String newPwd){
        return adminService.changeInfo(code, newPwd);
    }

    /**
     * 设置考试起止时间
     * */
    @PostMapping("/set/time")
    public ResponseItem<TimeItem> setExamTime(String startTime, String endTime){
        return adminService.setExamTime(startTime, endTime);
    }
}
