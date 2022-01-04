package com.thy.exam.service.impl;

import com.thy.exam.dao.TeachDao;
import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.SubjectItem;
import com.thy.exam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: thy
 * Date: 2022/1/4 14:37
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeachDao teachDao;
    @Autowired
    public void setTeachDao(TeachDao teachDao){
        this.teachDao = teachDao;
    }

    @Override
    public ResponseItem<SubjectItem> addSubject(String title, String choice, String type) {
        ResponseItem<SubjectItem> item = new ResponseItem<>();
        Integer result = teachDao.addSubject(title, choice, type);
        if(result > 0){
            // 添加成功
            item.setCode(0);
            item.setMsg("添加成功");
        }else{
            item.setCode(-1);
            item.setMsg("添加失败");
        }
        item.setCount(0);
        item.setData(null);

        return item;
    }

    @Override
    public ResponseItem<SubjectItem> getAllSubjects() {
        ResponseItem<SubjectItem> item = new ResponseItem<>();
        List<SubjectItem> subjects = teachDao.getAllSubjects();
        if(subjects != null){
            item.setCode(0);
            item.setMsg("查询成功");
            item.setData(subjects);
        }else {
            item.setCode(-1);
            item.setMsg("查询失败");
        }

        return item;
    }

    @Override
    public ResponseItem<SubjectItem> updateSubjectById(int id, String title, String choice, String type) {
        ResponseItem<SubjectItem> item = new ResponseItem<>();
        Integer result = teachDao.updateSubjectById(id, title, choice, type);
        if(result > 0){
            // 更新成功
            item.setCode(0);
            item.setMsg("更新成功");
        }else {
            item.setCode(-1);
            item.setMsg("更新失败");
        }

        return item;
    }

    @Override
    public ResponseItem<SubjectItem> deleteSubjectById(int id) {
        ResponseItem<SubjectItem> item = new ResponseItem<>();
        Integer result = teachDao.deleteSubjectById(id);
        if(result > 0){
            // 删除成功
            item.setCode(0);
            item.setMsg("删除成功");
        }else {
            item.setCode(-1);
            item.setMsg("删除失败");
        }

        return item;
    }

    @Override
    public ResponseItem<SubjectItem> generatePaper() {
        ResponseItem<SubjectItem> item = new ResponseItem<>();
        // 获取所有选择题
        List<SubjectItem> choiceSubjects = teachDao.choiceSubject();
        // 打乱选择题顺序
        Collections.shuffle(choiceSubjects);
        // 获取所有问答题
        List<SubjectItem> essaySubjects = teachDao.essaySubject();
        Collections.shuffle(essaySubjects);

        // 定义一个列表存放组卷得到的试题
        List<SubjectItem> list = new ArrayList<>();
        // 获取选择题个数
        int choiceCount = teachDao.getChoiceCount();
        // 获取问答题个数
        int essayCount = teachDao.getEssayCount();
        if(choiceCount > 0 && essayCount > 0){
            // 随机选择3个选择题2个问答题组成试卷
            if(choiceCount <=3){
                for(int i=0; i<choiceCount; i++){
                    list.add(choiceSubjects.get(i));
                }
            }else{
                for(int i=0; i<3; i++){
                    list.add(choiceSubjects.get(i));
                }
            }
            if(essayCount <=2){
                for(int i=0; i<essayCount; i++){
                    list.add(essaySubjects.get(i));
                }
            }else{
                for(int i=0; i<2; i++){
                    list.add(essaySubjects.get(i));
                }
            }
            item.setCode(0);
            item.setMsg("组卷成功");
            item.setData(list);
        }else{
            item.setCode(-1);
            item.setMsg("组卷失败，试题不存在");
        }

        return item;
    }
}
