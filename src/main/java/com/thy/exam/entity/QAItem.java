package com.thy.exam.entity;

import java.io.Serializable;

/**
 * Author: thy
 * 封装一个试卷条目
 */
public class QAItem implements Serializable {
    private static final long serialVersionUID = -6156449883811985487L;

    // 账号
    private String code;
    // 选择题1题目
    private String cqOne;
    // 选择题1答案
    private String cqOneAnswer;
    // 选择题2题目
    private String cqTwo;
    // 选择题2答案
    private String cqTwoAnswer;
    // 选择题3题目
    private String cqThree;
    // 选择题3答案
    private String cqThreeAnswer;
    // 问答题1题目
    private String eqOne;
    // 问答题2题目
    private String eqTwo;
    // 试卷标识符
    private String tag;
    // 试卷名
    private String name;

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

    public String getCqTwo() {
        return cqTwo;
    }

    public void setCqTwo(String cqTwo) {
        this.cqTwo = cqTwo;
    }

    public String getCqThree() {
        return cqThree;
    }

    public void setCqThree(String cqThree) {
        this.cqThree = cqThree;
    }

    public String getEqOne() {
        return eqOne;
    }

    public void setEqOne(String eqOne) {
        this.eqOne = eqOne;
    }

    public String getEqTwo() {
        return eqTwo;
    }

    public void setEqTwo(String eqTwo) {
        this.eqTwo = eqTwo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCqOneAnswer() {
        return cqOneAnswer;
    }

    public void setCqOneAnswer(String cqOneAnswer) {
        this.cqOneAnswer = cqOneAnswer;
    }

    public String getCqTwoAnswer() {
        return cqTwoAnswer;
    }

    public void setCqTwoAnswer(String cqTwoAnswer) {
        this.cqTwoAnswer = cqTwoAnswer;
    }

    public String getCqThreeAnswer() {
        return cqThreeAnswer;
    }

    public void setCqThreeAnswer(String cqThreeAnswer) {
        this.cqThreeAnswer = cqThreeAnswer;
    }
}
