package com.thy.exam.service;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.SubjectItem;

/**
 * Author: thy
 * Date: 2022/1/4 14:35
 */
public interface TeacherService {
    /**
     * 添加试题
     * */
    ResponseItem<SubjectItem> addSubject(String title, String choice, String type);

    /**
     * 查看当前题库的所有试题
     * */
    ResponseItem<SubjectItem> getAllSubjects();

    /**
     * 修改试题
     * */
    ResponseItem<SubjectItem> updateSubjectById(int id, String title, String choice, String type);

    /**
     * 删除试题
     * */
    ResponseItem<SubjectItem> deleteSubjectById(int id);

    /**
     * 随机生成试卷
     * */
    ResponseItem<SubjectItem> generatePaper(String code);

    /**
     * 查看学生试卷
     * */
    ResponseItem<StudentItem> getStudentPaper(String code, String tag);

    /**
     * 给学生试卷打分
     * */
    ResponseItem<StudentItem> setMarkToStudent(String code, String tag, String mark);

    /**
     * 查看所有学生成绩
     * */
    ResponseItem<StudentItem> getMarkForStudents(String tag);
}
