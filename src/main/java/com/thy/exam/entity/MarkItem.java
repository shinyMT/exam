package com.thy.exam.entity;

import java.io.Serializable;

/**
 * Author: thy
 * 封装一个成绩查询的条目
 */
public class MarkItem implements Serializable {
    private static final long serialVersionUID = 5673318681805226661L;

    // 试卷名
    private String name;
    // 成绩
    private String mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
