package com.thy.exam.entity;

import java.io.Serializable;

/**
 * Author: thy
 * Date: 2022/1/4 13:51
 */
public class SubjectItem implements Serializable {
    private static final long serialVersionUID = -2190415716574020140L;

    // 试题对应的ID
    private int id;
    // 题目
    private String title;
    // 选项
    private String choice;
    // 试题类型
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
