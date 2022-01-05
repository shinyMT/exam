package com.thy.exam.service.impl;

import com.thy.exam.dao.StudentDao;
import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.QAItem;
import com.thy.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: thy
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    @Autowired
    public void setStudentDao(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Override
    public ResponseItem<QAItem> getPaperByTag(String tag) {
        ResponseItem<QAItem> item = new ResponseItem<>();
        QAItem paper = studentDao.getPaperByTag(tag);
        if(paper != null){
            List<QAItem> paperList = new ArrayList<>();
            paperList.add(paper);
            item.setCode(0);
            item.setMsg("获取成功");
            item.setData(paperList);
        }else{
            item.setCode(-1);
            item.setMsg("获取失败");
        }

        return item;
    }

    @Override
    public ResponseItem<StudentItem> commitAnswer(String code, String cqOne, String caOne, String cqTwo,
                                             String caTwo, String cqThree, String caThree, String eqOne,
                                             String eaOne, String eqTwo, String eaTwo, String qaTag) {
        ResponseItem<StudentItem> item = new ResponseItem<>();
        // 提交前判断用户是否已经提交试卷
        StudentItem stuResult = studentDao.checkCommitStatus(code, qaTag);
        if(stuResult != null){
            // 用户已提交
            item.setCode(-2);
            item.setMsg("试卷已提交过");
        }else{
            Integer result = studentDao.commitAnswer(code, cqOne, caOne, cqTwo, caTwo, cqThree, caThree,
                    eqOne, eaOne, eqTwo, eaTwo, qaTag);
            if(result > 0){
                // 提交成功
                item.setCode(0);
                item.setMsg("提交成功");
            }else {
                item.setCode(-1);
                item.setMsg("提交失败");
            }
        }

        return item;
    }

    @Override
    public ResponseItem<StudentItem> searchScore(String code, String tag) {
        ResponseItem<StudentItem> item = new ResponseItem<>();
        StudentItem student = studentDao.searchScore(code, tag);
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
