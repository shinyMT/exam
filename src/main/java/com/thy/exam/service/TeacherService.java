package com.thy.exam.service;

import com.thy.exam.entity.QAItem;
import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.SubjectItem;

/**
 * Author: thy
 */
public interface TeacherService {
    /**
     * 添加试题
     * @param title 题目
     * @param choice 选项
     * @param type 题目类型
     * */
    ResponseItem<SubjectItem> addSubject(String title, String choice, String type);

    /**
     * 查看当前题库的所有试题
     * */
    ResponseItem<SubjectItem> getAllSubjects();

    /**
     * 修改试题
     * @param id 试题ID
     * @param title 题目
     * @param choice 选项
     * @param type 题目类型
     * */
    ResponseItem<SubjectItem> updateSubjectById(int id, String title, String choice, String type);

    /**
     * 删除试题
     * @param id 试题id
     * */
    ResponseItem<SubjectItem> deleteSubjectById(int id);

    /**
     * 随机生成试卷
     * @param code 教师账号
     * */
    ResponseItem<SubjectItem> generatePaper(String code, String name);

    /**
     * 查看学生试卷
     * @param code 学生账号
     * @param tag 试卷标识符
     * */
    ResponseItem<StudentItem> getStudentPaper(String code, String tag);

    /**
     * 给学生试卷打分
     * @param code 学生账号
     * @param name 试卷名
     * @param mark 分数
     * */
    ResponseItem<StudentItem> setMarkToStudent(String code, String name, String mark);

    /**
     * 查看所有学生成绩
     * @param name 试卷名
     * */
    ResponseItem<StudentItem> getMarkForStudents(String name);

    /**
     * 修改学生成绩
     * @param code 学生账号
     * @param mark 新成绩
     * @param tag 试卷标识符
     * */
    ResponseItem<StudentItem> updateStudentMark(String code, String mark, String tag);
}
