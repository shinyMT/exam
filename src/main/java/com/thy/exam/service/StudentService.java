package com.thy.exam.service;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.QAItem;

public interface StudentService {
    /**
     * 获取试卷
     * @param tag 试卷标识符
     * */
    ResponseItem<QAItem> getPaperByTag(String tag);

    /**
     * 提交试卷
     * @param code 学生账号
     * @param cqOne 选择题1题目
     * @param caOne 选择题1答案
     * @param cqTwo 选择题2题目
     * @param caTwo 选择题2答案
     * @param cqThree 选择题3题目
     * @param caThree 选择题3答案
     * @param eqOne 问答题1题目
     * @param eaOne 问答题1答案
     * @param eqTwo 问答题2题目
     * @param eaTwo 问答题2答案
     * @param qaTag 试卷标识符
     * */
    ResponseItem<StudentItem> commitAnswer(String code, String cqOne, String caOne, String cqTwo, String caTwo,
                                      String cqThree, String caThree, String eqOne, String eaOne,
                                      String eqTwo, String eaTwo, String qaTag);

    /**
     * 查询成绩
     * @param code 学生账号
     * @param tag 试卷标识符
     * */
    ResponseItem<StudentItem> searchScore(String code, String tag);
}
