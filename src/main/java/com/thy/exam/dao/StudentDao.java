package com.thy.exam.dao;

import com.thy.exam.entity.StudentItem;
import com.thy.exam.sql.StudentSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface StudentDao {
    /**
     * 提交试卷
     * */
    @InsertProvider(type = StudentSql.class, method = "commitAnswer")
    Integer commitAnswer(String code, String cqOne, String caOne, String cqTwo, String caTwo,
                         String cqThree, String caThree, String eqOne, String eaOne,
                         String eqTwo, String eaTwo);

    /**
     * 查询成绩
     * */
    @SelectProvider(type = StudentSql.class, method = "searchScore")
    StudentItem searchScore(String code);
}
