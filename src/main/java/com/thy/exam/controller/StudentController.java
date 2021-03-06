package com.thy.exam.controller;

import com.thy.exam.entity.*;
import com.thy.exam.service.StudentService;
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
public class StudentController {
    private StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService){
        this.studentService = studentService;
    }

    /**
     * 获取所有试卷名
     * */
    @GetMapping("/all/paper")
    public ResponseItem<QAItem> getAllPaper(){
        return studentService.getAllPaper();
    }

    /**
     * 判断用户是否已经提交过试卷
     * */
    @PostMapping("/check/commit")
    public ResponseItem<StudentItem> checkCommitStatus(String code, String name){
        return studentService.checkCommitStatus(code, name);
    }

    /**
     * 获取试卷
     * */
    @PostMapping("/get/paper")
    public ResponseItem<QAItem> getPaperByName(String name){
        return studentService.getPaperByName(name);
    }

    /**
     * 提交试卷
     * */
    @PostMapping("/commit")
    public ResponseItem<StudentItem> commitAnswer(String code, String cqOne, String caOne,
                                             String cqTwo, String caTwo, String cqThree, String caThree,
                                             String eqOne, String eaOne, String eqTwo, String eaTwo, String qaTag){
        return studentService.commitAnswer(code, cqOne, caOne, cqTwo, caTwo, cqThree, caThree, eqOne, eaOne, eqTwo, eaTwo, qaTag);
    }

    /**
     * 查询成绩
     * */
    @PostMapping("/search/mark")
    public ResponseItem<MarkItem> searchScore(String code){
        return studentService.searchScore(code);
    }

    /**
     * 查询考试时间
     * */
    @PostMapping("/get/time")
    public ResponseItem<TimeItem> getExamTime(String name){
        return studentService.getExamTime(name);
    }
}
