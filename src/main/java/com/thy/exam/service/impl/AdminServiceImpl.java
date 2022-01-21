package com.thy.exam.service.impl;

import com.thy.exam.dao.AdminDao;
import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.TimeItem;
import com.thy.exam.entity.UserItem;
import com.thy.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
     * 验证用户身份
     * */
    @Override
    public ResponseItem<UserItem> checkIdentity(String code, String password) {
        ResponseItem<UserItem> item = new ResponseItem<>();
        UserItem user = adminDao.checkIdentity(code);
        if(user != null){
            // 存在用户
            String pwd = user.getPassword();
            if(pwd.equals(password)){
                item.setCode(0);
                item.setMsg("验证成功");
                List<UserItem> list = new ArrayList<>();
                list.add(user);
                item.setData(list);
            }else{
                item.setCode(-1);
                item.setMsg("密码错误");
            }
        }else{
            item.setCode(-2);
            item.setMsg("账号不存在");
        }

        return item;
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
}
