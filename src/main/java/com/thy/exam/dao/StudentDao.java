package com.thy.exam.dao;

import com.thy.exam.entity.QAItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.TimeItem;
import com.thy.exam.sql.StudentSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface StudentDao {

    /**
     * 获取所有试卷
     * */
    @SelectProvider(type = StudentSql.class, method = "getAllPaper")
    List<QAItem> getAllPaper();

    /**
     * 通过试卷名获取试卷标识
     * */
    @SelectProvider(type = StudentSql.class, method = "getPaperTagByName")
    QAItem getPaperTagByName(String name);

    /**
     * 获取试卷
     * */
    @SelectProvider(type = StudentSql.class, method = "getPaperByTag")
    QAItem getPaperByTag(String tag);

    /**
     * 判断试卷提交状态
     * */
    @SelectProvider(type = StudentSql.class, method = "checkCommitStatus")
    StudentItem checkCommitStatus(String code, String tag);

    /**
     * 提交试卷
     * */
    @InsertProvider(type = StudentSql.class, method = "commitAnswer")
    Integer commitAnswer(String code, String cqOne, String caOne, String cqTwo, String caTwo,
                         String cqThree, String caThree, String eqOne, String eaOne,
                         String eqTwo, String eaTwo, String qaTag);

    /**
     * 查询成绩
     * */
    @SelectProvider(type = StudentSql.class, method = "searchScore")
    StudentItem searchScore(String code, String tag);

    /**
     * 获取考试时间
     * */
    @SelectProvider(type = StudentSql.class, method = "getExamTime")
    TimeItem getExamTime();
}
