package com.thy.exam.entity;

import java.io.Serializable;

/**
 * Author: thy
 * 封装一个学生条目
 */
public class StudentItem implements Serializable {
    private static final long serialVersionUID = 1249295592515467013L;

    // id
    private int id;
    // 账号
    private String code;
    // 选择题1题目
    private String cqOne;
    // 选择题1答案
    private String caOne;
    // 选择题2题目
    private String cqTwo;
    // 选择题2答案
    private String caTwo;
    // 选择题3题目
    private String cqThree;
    // 选择题3答案
    private String caThree;
    // 问答题1题目
    private String eqOne;
    // 问答题1答案
    private String eaOne;
    // 问答题2题目
    private String eqTwo;
    // 问答题2答案
    private String eaTwo;
    // 成绩
    private String mark;
    // 试卷标识符
    private String qaTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCqOne() {
        return cqOne;
    }

    public void setCqOne(String cqOne) {
        this.cqOne = cqOne;
    }

    public String getCaOne() {
        return caOne;
    }

    public void setCaOne(String caOne) {
        this.caOne = caOne;
    }

    public String getCqTwo() {
        return cqTwo;
    }

    public void setCqTwo(String cqTwo) {
        this.cqTwo = cqTwo;
    }

    public String getCaTwo() {
        return caTwo;
    }

    public void setCaTwo(String caTwo) {
        this.caTwo = caTwo;
    }

    public String getCqThree() {
        return cqThree;
    }

    public void setCqThree(String cqThree) {
        this.cqThree = cqThree;
    }

    public String getCaThree() {
        return caThree;
    }

    public void setCaThree(String caThree) {
        this.caThree = caThree;
    }

    public String getEqOne() {
        return eqOne;
    }

    public void setEqOne(String eqOne) {
        this.eqOne = eqOne;
    }

    public String getEaOne() {
        return eaOne;
    }

    public void setEaOne(String eaOne) {
        this.eaOne = eaOne;
    }

    public String getEqTwo() {
        return eqTwo;
    }

    public void setEqTwo(String eqTwo) {
        this.eqTwo = eqTwo;
    }

    public String getEaTwo() {
        return eaTwo;
    }

    public void setEaTwo(String eaTwo) {
        this.eaTwo = eaTwo;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getQaTag() {
        return qaTag;
    }

    public void setQaTag(String qaTag) {
        this.qaTag = qaTag;
    }
}
