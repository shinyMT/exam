package com.thy.exam.sql;

import org.apache.ibatis.jdbc.SQL;

/**
 * Author: thy
 */
public class StudentSql {
    private static final String STUDENT_TABLE = "student";
    private static final String QA_TABLE = "qa";
    private static final String TIME_TABLE = "time";

    /**
     * 获取所有试卷
     * */
    public String getAllPaper(){
        return "select tag, name from " + QA_TABLE;
    }

    /**
     * 获取试卷标识
     * @param name 试卷名
     * */
    public String getPaperTagByName(String name){
        SQL sql = new SQL();
        sql.SELECT("tag");
        sql.FROM(QA_TABLE);
        sql.WHERE("name='" + name + "'");

        return sql.toString();
    }

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
     * @param code 学生账号
     * @param cqOne 选择题1题目
     * @param caOne 选择题1答案
     * @param cqTwo 选择题2题目
     * @param caTwo 选择题2答案
     * @param cqThree 选择题3题目
     * @param caThree 选择题3答案
     * @param eqOne 问答题1题目
     * @param eaOne 问答题1答案
     * @param eqTwo 问答题2题目
     * @param eaTwo 问答题2答案
     * @param qaTag 试卷标识符
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
     * */
    public String searchScore(String code){
        SQL sql = new SQL();
        sql.SELECT("s.mark, q.name");
        sql.FROM(STUDENT_TABLE + " s");
        sql.LEFT_OUTER_JOIN(QA_TABLE + " q on s.qaTag=q.tag");
        sql.WHERE("s.code='" + code + "'");

        return sql.toString();
    }

    /**
     * 根据试卷标识获取考试时间
     * @param tag 试卷标识符
     * */
    public String getExamTime(String tag){
        return "select * from " + TIME_TABLE + " where tag='" + tag + "'";
    }
}
