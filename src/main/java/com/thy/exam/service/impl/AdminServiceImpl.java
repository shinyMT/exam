package com.thy.exam.service.impl;

import com.thy.exam.dao.AdminDao;
import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.TimeItem;
import com.thy.exam.entity.UserItem;
import com.thy.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: thy
 */
@Service
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;
    @Autowired
    public void setAdminDao(AdminDao adminDao){
        this.adminDao = adminDao;
    }

    /**
     * 修改账户信息
     * */
    @Override
    public ResponseItem<UserItem> changeInfo(String code, String newPwd) {
        ResponseItem<UserItem> item = new ResponseItem<>();
        Integer result = adminDao.changeInfo(code, newPwd);
        if(result > 0){
            // 更新成功
            item.setCode(0);
            item.setMsg("修改成功");
        }else{
            item.setCode(-1);
            item.setMsg("修改失败");
        }
        item.setCount(0);
        item.setData(null);

        return item;
    }

    /**
     * 设置考试起止时间
     * */
    @Override
    public ResponseItem<TimeItem> setExamTime(String startTime, String endTime) {
        ResponseItem<TimeItem> item = new ResponseItem<>();
        Integer result = adminDao.setExamTime(startTime, endTime);
        if(result > 0){
            item.setCode(0);
            item.setMsg("设置成功");
        }else {
            item.setCode(-1);
            item.setMsg("设置失败");
        }

        return item;
    }
}
