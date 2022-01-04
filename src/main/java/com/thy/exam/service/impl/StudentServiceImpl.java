package com.thy.exam.service.impl;

import com.thy.exam.dao.StudentDao;
import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.StudentQAItem;
import com.thy.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: thy
 * Date: 2022/1/4 20:05
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    @Autowired
    public void setStudentDao(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Override
    public ResponseItem<StudentQAItem> commitAnswer(String code, String cqOne, String caOne,
                                                    String cqTwo, String caTwo, String cqThree, String caThree,
                                                    String eqOne, String eaOne, String eqTwo, String eaTwo) {
        ResponseItem<StudentQAItem> item = new ResponseItem<>();
        Integer result = studentDao.commitAnswer(code, cqOne, caOne, cqTwo, caTwo, cqThree, caThree, eqOne, eaOne, eqTwo, eaTwo);
        if(result > 0){
            // 提交成功
            item.setCode(0);
            item.setMsg("提交成功");
        }else {
            item.setCode(-1);
            item.setMsg("提交失败");
        }

        return item;
    }

    @Override
    public ResponseItem<StudentItem> searchScore(String code) {
        ResponseItem<StudentItem> item = new ResponseItem<>();
        StudentItem student = studentDao.searchScore(code);
        if(student != null){
            // 查询成功
            List<StudentItem> list = new ArrayList<>();
            list.add(student);
            item.setCode(0);
            item.setMsg("查询成功");
            item.setData(list);
        }else{
            item.setCode(-1);
            item.setMsg("查询失败");
        }

        return item;
    }
}
