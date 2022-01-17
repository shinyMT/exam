package com.thy.exam.dao;

import com.thy.exam.entity.QAItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.SubjectItem;
import com.thy.exam.sql.TeacherSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author: thy
 */
@Mapper
public interface TeachDao {
    /**
     * 添加试题
     * */
    @InsertProvider(type = TeacherSql.class, method = "addSubject")
    Integer addSubject(String title, String choice, String type);

    /**
     * 查看当前题库的所有试题
     * */
    @SelectProvider(type = TeacherSql.class, method = "getAllSubjects")
    List<SubjectItem> getAllSubjects();

    /**
     * 获取当前题库总数
     * */
    @SelectProvider(type = TeacherSql.class, method = "getSubjectCount")
    Integer getSubjectCount();

    /**
     * 获取所有选择题
     * */
    @SelectProvider(type = TeacherSql.class, method = "choiceSubject")
    List<SubjectItem> choiceSubject();

    /**
     * 获取选择题总数
     * */
    @SelectProvider(type = TeacherSql.class, method = "getChoiceCount")
    Integer getChoiceCount();

    /**
     * 获取所有问答题
     * */
    @SelectProvider(type = TeacherSql.class, method = "essaySubject")
    List<SubjectItem> essaySubject();

    /**
     * 获取问答题总数
     * */
    @SelectProvider(type = TeacherSql.class, method = "getEssayCount")
    Integer getEssayCount();

    /**
     * 修改试题
     * */
    @UpdateProvider(type = TeacherSql.class, method = "updateSubjectById")
    Integer updateSubjectById(int id, String title, String choice, String type);

    /**
     * 删除试题
     * */
    @DeleteProvider(type = TeacherSql.class, method = "deleteSubjectById")
    Integer deleteSubjectById(int id);

    /**
     * 判断当前试卷库是否存在同名试卷
     * */
    @SelectProvider(type = TeacherSql.class, method = "checkPaperStatus")
    QAItem checkPaperStatus(String name);

    /**
     * 存储组卷完成的试卷信息
     * */
    @InsertProvider(type = TeacherSql.class, method = "saveDonePaper")
    Integer saveDonePaper(String tag, String cqOne, String cqTwo, String cqThree,
                          String eqOne, String eqTwo, String name);

    /**
     * 查看学生试卷
     * */
    @SelectProvider(type = TeacherSql.class, method = "getStudentPaper")
    StudentItem getStudentPaper(String code, String tag);

    /**
     * 给学生试卷打分
     * */
    @UpdateProvider(type = TeacherSql.class, method = "setMarkToStudent")
    Integer setMarkToStudent(String code, String tag, String mark);

    /**
     * 查看所有学生分数
     * */
    @SelectProvider(type = TeacherSql.class, method = "getMarkForStudents")
    List<StudentItem> getMarkForStudents(String tag);

    /**
     * 修改学生成绩
     * */
    @UpdateProvider(type = TeacherSql.class, method = "updateStudentMark")
    Integer updateStudentMark(String code, String mark, String tag);
}
