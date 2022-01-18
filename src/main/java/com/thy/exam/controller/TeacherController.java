package com.thy.exam.controller;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.SubjectItem;
import com.thy.exam.service.TeacherService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: thy
 */
@RestController
@NoArgsConstructor
public class TeacherController {
    private TeacherService teacherService;
    @Autowired
    public void setTeacherService(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    /**
     * 添加试题
     * */
    @PostMapping("/add/subject")
    public ResponseItem<SubjectItem> addSubject(String title, String choice, String type){
        return teacherService.addSubject(title, choice, type);
    }

    /**
     * 查询当前题库的所有试题
     * */
    @GetMapping("/all")
    public ResponseItem<SubjectItem> getAllSubjects(){
        return teacherService.getAllSubjects();
    }

    /**
     * 修改试题
     * */
    @PostMapping("/update/subject")
    public ResponseItem<SubjectItem> updateSubjectById(int id, String title, String choice, String type){
        return teacherService.updateSubjectById(id, title, choice, type);
    }

    /**
     * 删除试题
     * */
    @GetMapping("/del/subject")
    public ResponseItem<SubjectItem> deleteSubjectById(int id){
        return teacherService.deleteSubjectById(id);
    }

    /**
     * 随机生成试卷
     * */
    @GetMapping("/generate")
    public ResponseItem<SubjectItem> generatePaper(String code, String name){
        return teacherService.generatePaper(code, name);
    }

    /**
     * 获取学生试卷
     * */
    @PostMapping("/get/stu/paper")
    public ResponseItem<StudentItem> getStudentPaper(String code, String name){
        return teacherService.getStudentPaper(code, name);
    }

    /**
     * 给学生试卷打分
     * */
    @PostMapping("/set/mark")
    public ResponseItem<StudentItem> setMarkToStudent(String code, String name, String mark){
        return teacherService.setMarkToStudent(code, name, mark);
    }

    /**
     * 查询所有学生的成绩
     * */
    @PostMapping("/all/mark")
    public ResponseItem<StudentItem> getMarkForStudents(String name){
        return teacherService.getMarkForStudents(name);
    }

    /**
     * 修改学生成绩
     * */
    @PostMapping("/update/mark")
    public ResponseItem<StudentItem> updateStudentMark(String code, String mark, String tag){
        return teacherService.updateStudentMark(code, mark, tag);
    }
}
