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
     * 提交试卷
     * */
    public String commitAnswer(String code, String cqOne, String caOne, String cqTwo, String caTwo,
                               String cqThree, String caThree, String eqOne, String eaOne,
                               String eqTwo, String eaTwo){
        SQL sql = new SQL();
        sql.INSERT_INTO(QA_TABLE);
        sql.VALUES("code, cqOne, caOne, cqTwo, caTwo, cqThree, caThree," +
                "eqOne, eaOne, eqTwo, eaTwo",
                code + cqOne + caOne + cqTwo + caTwo + cqThree + caThree + eqOne + eaOne + eqTwo + eaTwo);

        System.out.println(sql);
        return sql.toString();
    }

    /**
     * 查询成绩
     * @param code 学生账号
     * */
    public String searchScore(String code){
        return "select mark from " + STUDENT_TABLE + " where code='" + code + "'";
    }
}
