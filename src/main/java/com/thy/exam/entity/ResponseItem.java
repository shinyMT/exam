package com.thy.exam.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Author: thy
 * Date: 2022/1/4 14:05
 */
public class ResponseItem<T> implements Serializable {
    private static final long serialVersionUID = 8636784335318533156L;

    // 响应代码
    private int code;
    // 响应消息
    private String msg;
    // 响应数量
    private int count;
    // 响应数据
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}