package com.thy.exam.entity;

import java.io.Serializable;

/**
 * Author: thy
 */
public class UserItem implements Serializable {
    private static final long serialVersionUID = -2839177392298732418L;
    // 账号
    private String code;
    // 姓名
    private String name;
    // 密码
    private String password;
    // 身份标识
    private String tag;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
