package com.thy.exam.entity;

import java.io.Serializable;

/**
 * Author: thy
 * Date: 2022/1/4 13:54
 */
public class StudentItem implements Serializable {
    private static final long serialVersionUID = 1249295592515467013L;

    // 账号
    private String code;
    // 成绩
    private String mark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
