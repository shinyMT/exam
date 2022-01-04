package com.thy.exam.dao;

import com.thy.exam.entity.SubjectItem;
import com.thy.exam.sql.TeacherSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author: thy
 * Date: 2022/1/4 14:33
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
}
