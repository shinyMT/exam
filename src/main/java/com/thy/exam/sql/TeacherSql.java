package com.thy.exam.sql;

import com.thy.exam.entity.QAItem;
import org.apache.ibatis.jdbc.SQL;

/**
 * Author: thy
 * Date: 2022/1/4 13:55
 */
public class TeacherSql {
    // 定义常量存放表名
    private static final String SUBJECT_TABLE = "subject";
    private static final String QA_TABLE = "qa";
    private static final String STUDENT_TABLE = "student";

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

    /**
     * 判断当前试卷库中是否存在同名试卷
     * @param name 试卷名
     * */
    public String checkPaperStatus(String name){
        return "select * from " + QA_TABLE + " where name='" + name + "'";
    }

    /**
     * 存储组卷好的试题
     * @param cqOne 选择题1的题目
     * @param cqTwo 选择题2的题目
     * @param cqThree 选择题3的题目
     * @param eqOne 问答题1的题目
     * @param eqTwo 问答题2的题目
     * @param tag 试卷标识符
     * */
    public String saveDonePaper(String tag, String cqOne, String cqTwo, String cqThree,
                               String eqOne, String eqTwo, String name){
        SQL sql = new SQL();
        sql.INSERT_INTO(QA_TABLE);
        sql.VALUES("tag, cqOne, cqTwo, cqThree, eqOne, eqTwo, name", "'" + tag + "', '" + cqOne + "', '"
        + cqTwo + "', '" + cqThree + "', '" + eqOne + "', '" + eqTwo + "', '" + name + "'");
//        System.out.println(sql);
        return sql.toString();
    }

    /**
     * 查看学生试卷
     * @param code 学生账号
     * @param tag 试卷标识符
     * */
    public String getStudentPaper(String code, String tag){
        return "select * from " + STUDENT_TABLE + " where code='" + code + "' and qaTag='" + tag + "'";
    }

    /**
     * 给学生试卷打分
     * @param code 学生账号
     * @param tag 试卷标识符
     * @param mark 试卷成绩
     * */
    public String setMarkToStudent(String code, String tag, String mark){
        SQL sql = new SQL();
        sql.UPDATE(STUDENT_TABLE);
        sql.SET("mark='" + mark + "' where code='" + code + "' and qaTag='" + tag + "'");

        return sql.toString();
    }

    /**
     * 查看所有学生成绩
     * @param tag 试卷标识符
     * */
    public String getMarkForStudents(String tag){
        return "select code, mark from " + STUDENT_TABLE + " where qaTag='" + tag + "'";
    }

    /**
     * 修改学生试卷成绩
     * @param code 学生账号
     * @param mark 新成绩
     * @param tag 试卷标识符
     * */
    public String updateStudentMark(String code, String mark, String tag){
        SQL sql = new SQL();
        sql.UPDATE(STUDENT_TABLE);
        sql.SET("mark='" + mark + "' where code='" + code + "' and qaTag='" + tag + "'");

        return sql.toString();
    }
}
