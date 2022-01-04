package com.thy.exam.service;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.StudentQAItem;

public interface StudentService {
    /**
     * 提交试卷
     * */
    ResponseItem<StudentQAItem> commitAnswer(String code, String cqOne, String caOne, String cqTwo, String caTwo,
                                             String cqThree, String caThree, String eqOne, String eaOne,
                                             String eqTwo, String eaTwo);

    /**
     * 查询成绩
     * */
    ResponseItem<StudentItem> searchScore(String code);
}
