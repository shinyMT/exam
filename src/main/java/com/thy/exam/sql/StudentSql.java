package com.thy.exam.sql;

import org.apache.ibatis.jdbc.SQL;

/**
 * Author: thy
 * Date: 2022/1/4 16:30
 */
public class StudentSql {
    private static final String STUDENT_TABLE = "student";
    private static final String QA_TABLE = "qa";

    /**
     * 根据标识获取试卷
     * @param tag 试卷标识符
     * */
    public String getPaperByTag(String tag){
        return "select * from " + QA_TABLE + " where tag='" + tag + "'";
    }

    /**
     * 判断用户是否已经提交过试卷
     * @param code 学生账号
     * @param tag 试卷标识符
     * */
    public String checkCommitStatus(String code, String tag){
        return "select * from " + STUDENT_TABLE + " where code='" + code + "' and qaTag='" + tag + "'";
    }

    /**
     * 提交试卷
     * */
    public String commitAnswer(String code, String cqOne, String caOne, String cqTwo, String caTwo,
                               String cqThree, String caThree, String eqOne, String eaOne,
                               String eqTwo, String eaTwo, String qaTag){
        SQL sql = new SQL();
        sql.INSERT_INTO(STUDENT_TABLE);
        sql.VALUES("code, cqOne, caOne, cqTwo, caTwo, cqThree, caThree," +
                "eqOne, eaOne, eqTwo, eaTwo, qaTag",
                "'" + code + "', '" + cqOne + "', '" + caOne + "', '" + cqTwo + "', '" + caTwo + "', '" +
                        cqThree + "', '" + caThree + "', '" + eqOne + "', '" + eaOne + "', '" + eqTwo + "', '" +
                        eaTwo + "', '" + qaTag + "'");

//        System.out.println(sql);
        return sql.toString();
    }

    /**
     * 查询成绩
     * @param code 学生账号
     * @param tag 试卷标识符
     * */
    public String searchScore(String code, String tag){
        return "select mark from " + STUDENT_TABLE + " where code='" + code + "' and qaTag='" + tag + "'";
    }
}
