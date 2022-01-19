package com.thy.exam.service.impl;

import com.thy.exam.dao.StudentDao;
import com.thy.exam.entity.*;
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

    /**
     * 获取所有试卷名
     * */
    @Override
    public ResponseItem<QAItem> getAllPaper() {
        ResponseItem<QAItem> item = new ResponseItem<>();
        List<QAItem> qaList = studentDao.getAllPaper();
        if(qaList != null){
            item.setCode(0);
            item.setMsg("获取成功");
            item.setData(qaList);
        }else{
            item.setCode(-1);
            item.setMsg("获取失败");
        }

        return item;
    }

    @Override
    public ResponseItem<StudentItem> checkCommitStatus(String code, String name) {
        ResponseItem<StudentItem> item = new ResponseItem<>();
        QAItem qa = studentDao.getPaperTagByName(name);
        if(qa != null){
            // 获取试卷标识符
            String tag = qa.getTag();
            StudentItem student = studentDao.checkCommitStatus(code, tag);
            if(student != null){
                // 已经提交过
                item.setCode(-1);
                item.setMsg("已提交过试卷");
            }else {
                item.setCode(0);
                item.setMsg("未提交过试卷");
            }
        }else{
            item.setCode(-2);
            item.setMsg("试卷不存在");
        }

        return  item;
    }

    /**
     * 获取试卷
     * */
    @Override
    public ResponseItem<QAItem> getPaperByName(String name) {
        ResponseItem<QAItem> item = new ResponseItem<>();
        QAItem qaItem = studentDao.getPaperTagByName(name);
        if(qaItem == null){
            item.setCode(-2);
            item.setMsg("获取试卷标识失败");
        }else{
            String tag = qaItem.getTag();
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
        }

        return item;
    }

    /**
     * 提交试卷
     * */
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

    /**
     * 查询成绩
     * */
    @Override
    public ResponseItem<MarkItem> searchScore(String code) {
        ResponseItem<MarkItem> item = new ResponseItem<>();
        List<MarkItem> studentList = studentDao.searchScore(code);
        if(studentList != null){
            // 查询成功
            item.setCode(0);
            item.setMsg("查询成功");
            item.setData(studentList);
        }else{
            item.setCode(-1);
            item.setMsg("查询失败");
        }

        return item;
    }

    @Override
    public ResponseItem<TimeItem> getExamTime(String name) {
        ResponseItem<TimeItem> item = new ResponseItem<>();
        QAItem qa = studentDao.getPaperTagByName(name);
        if(qa != null){
            String tag = qa.getTag();
            TimeItem examTime = studentDao.getExamTime(tag);
            if(examTime != null){
                List<TimeItem> list = new ArrayList<>();
                list.add(examTime);

                item.setCode(0);
                item.setMsg("获取成功");
                item.setData(list);
            }else {
                item.setCode(-1);
                item.setMsg("获取失败");
            }
        }else {
            item.setCode(-2);
            item.setMsg("查询试卷失败");
        }

        return item;
    }
}
