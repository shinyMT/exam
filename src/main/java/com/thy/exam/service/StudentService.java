package com.thy.exam.service;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.QAItem;

public interface StudentService {
    /**
     * 获取试卷
     * */
    ResponseItem<QAItem> getPaperByTag(String tag);

    /**
     * 提交试卷
     * */
    ResponseItem<StudentItem> commitAnswer(String code, String cqOne, String caOne, String cqTwo, String caTwo,
                                      String cqThree, String caThree, String eqOne, String eaOne,
                                      String eqTwo, String eaTwo, String qaTag);

    /**
     * 查询成绩
     * */
    ResponseItem<StudentItem> searchScore(String code, String tag);
}
