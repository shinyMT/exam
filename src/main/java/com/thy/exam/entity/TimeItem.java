package com.thy.exam.entity;

import java.io.Serializable;

/**
 * Author: thy
 * Date: 2022/1/4 13:52
 */
public class TimeItem implements Serializable {
    private static final long serialVersionUID = -2625023513326278205L;

    // id
    private int id;
    // 开始时间
    private String startTime;
    // 结束时间
    private String endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
