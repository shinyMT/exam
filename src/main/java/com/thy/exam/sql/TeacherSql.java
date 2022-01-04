package com.thy.exam.sql;

import org.apache.ibatis.jdbc.SQL;

/**
 * Author: thy
 * Date: 2022/1/4 13:55
 */
public class TeacherSql {
    // 定义常量存放表名
    private static final String SUBJECT_TABLE = "subject";

    /**
     * 添加试题
     * @param title 题目
     * @param choice 选项
     * @param type 题目类型
     * */
    public String addSubject(String title, String choice, String type){
        SQL sql = new SQL();
        sql.INSERT_INTO(SUBJECT_TABLE);
        sql.VALUES("title, choice, type", "'" + title + "', '" + choice + "', '" + type + "'");

        return sql.toString();
    }

    /**
     * 查看所有试题
     * */
    public String getAllSubjects(){
        return "select * from " + SUBJECT_TABLE;
    }

    /**
     * 获取试题的总数
     * */
    public String getSubjectCount(){
        return "select count(id) from " + SUBJECT_TABLE;
    }

    /**
     * 获取所有选择题
     * */
    public String choiceSubject(){
        return "select * from " + SUBJECT_TABLE + " where type='1'";
    }

    /**
     * 获取选择题总数
     * */
    public String getChoiceCount(){
        return "select count(id) from " + SUBJECT_TABLE + " where type='1'";
    }

    /**
     * 获取所有问答题
     * */
    public String essaySubject(){
        return "select * from " + SUBJECT_TABLE + " where type='2'";
    }

    /**
     * 获取所有问答题总数
     * */
    public String getEssayCount(){
        return "select count(id) from " + SUBJECT_TABLE + " where type='2'";
    }

    /**
     * 修改试题
     * @param id 试题ID
     * @param title 新题目
     * @param choice 新选项
     * @param type 新题目类型
     * */
    public String updateSubjectById(int id, String title, String choice, String type){
        SQL sql = new SQL();
        sql.UPDATE(SUBJECT_TABLE);
        sql.SET("title='" + title + "', choice='" + choice + "', type='" + type + "'");
        sql.WHERE("id=" + id);

//        System.out.println(sql);
        return sql.toString();
    }

    /**
     * 删除试题
     * @param id 试题ID
     * */
    public String deleteSubjectById(int id){
        SQL sql = new SQL();
        sql.DELETE_FROM(SUBJECT_TABLE);
        sql.WHERE("id=" + id);

        return sql.toString();
    }
}
