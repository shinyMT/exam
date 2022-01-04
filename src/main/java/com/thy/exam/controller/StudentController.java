package com.thy.exam.controller;

import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.StudentQAItem;
import com.thy.exam.service.StudentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: thy
 * Date: 2022/1/4 20:08
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
     * 提交试卷----待测试
     * */
    @PatchMapping("/commit")
    public ResponseItem<StudentQAItem> commitAnswer(String code, String cqOne, String caOne,
                                                    String cqTwo, String caTwo, String cqThree, String caThree,
                                                    String eqOne, String eaOne, String eqTwo, String eaTwo){
        return studentService.commitAnswer(code, cqOne, caOne, cqTwo, caTwo, cqThree, caThree, eqOne, eaOne, eqTwo, eaTwo);
    }

    /**
     * 查询成绩 -- 待测试
     * */
    @GetMapping("/search/score")
    public ResponseItem<StudentItem> searchScore(String code){
        return studentService.searchScore(code);
    }
}
