package com.thy.exam.service.impl;

import com.thy.exam.dao.StudentDao;
import com.thy.exam.dao.TeachDao;
import com.thy.exam.entity.QAItem;
import com.thy.exam.entity.ResponseItem;
import com.thy.exam.entity.StudentItem;
import com.thy.exam.entity.SubjectItem;
import com.thy.exam.service.TeacherService;
import com.thy.exam.util.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: thy
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeachDao teachDao;
    private StudentDao studentDao;
    @Autowired
    public void setTeachDao(TeachDao teachDao, StudentDao studentDao){
        this.teachDao = teachDao;
        this.studentDao = studentDao;
    }

    /**
     * 添加试题
     * */
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

    /**
     * 查看当前题库中的所有试题
     * */
    @Override
    public ResponseItem<SubjectItem> getAllSubjects() {
        ResponseItem<SubjectItem> item = new ResponseItem<>();
        List<SubjectItem> subjects = teachDao.getAllSubjects();
        int count = teachDao.getSubjectCount();
        if(subjects != null){
            item.setCode(0);
            item.setMsg("查询成功");
            item.setCount(count);
            item.setData(subjects);
        }else {
            item.setCode(-1);
            item.setMsg("查询失败");
        }

        return item;
    }

    /**
     * 修改试题
     * */
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

    /**
     * 删除试题
     * */
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

    /**
     * 随机生成试卷
     * */
    @Override
    public ResponseItem<SubjectItem> generatePaper(String code, String name) {
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
            // 组卷完成后生成该试卷的唯一标识符
            TagUtil tagUtil = new TagUtil();
            String tag = tagUtil.generateTag(code);
            // 获取组卷得到的题目
            String cqOne = list.get(0).getTitle() + ":" + list.get(0).getChoice();
            String cqTwo = list.get(1).getTitle() + ":" + list.get(1).getChoice();
            String cqThree = list.get(2).getTitle() + ":" + list.get(2).getChoice();
            String eqOne = list.get(3).getTitle();
            String eqTwo = list.get(4).getTitle();
            // 将组卷的结果写入数据库中存储
            Integer res = teachDao.saveDonePaper(tag, cqOne, cqTwo, cqThree, eqOne, eqTwo, name);
            if(res > 0){
                // 存储成功
                item.setCode(0);
                item.setMsg("组卷成功，" + tag);
                item.setData(list);
            }
        }else{
            item.setCode(-1);
            item.setMsg("组卷失败，试题不存在");
        }

        return item;
    }

    /**
     * 查看学生试卷
     * */
    @Override
    public ResponseItem<StudentItem> getStudentPaper(String code, String name) {
        ResponseItem<StudentItem> item = new ResponseItem<>();
        QAItem qa = studentDao.getPaperTagByName(name);
        if(qa != null){
            String tag = qa.getTag();
//            System.out.println(tag);
            StudentItem studentPaper = teachDao.getStudentPaper(code, tag);
            if(studentPaper != null){
                List<StudentItem> list = new ArrayList<>();
                list.add(studentPaper);
                item.setCode(0);
                item.setMsg("查询成功");
                item.setData(list);
            }else{
                item.setCode(-1);
                item.setMsg("查询失败");
            }
        }else {
            item.setCode(-2);
            item.setMsg("试卷不存在");
        }

        return item;
    }

    /**
     * 给学生试卷打分
     * */
    @Override
    public ResponseItem<StudentItem> setMarkToStudent(String code, String name, String mark) {
        ResponseItem<StudentItem> item = new ResponseItem<>();
        QAItem qa = studentDao.getPaperTagByName(name);
        if(qa != null){
            String tag = qa.getTag();
            Integer result = teachDao.setMarkToStudent(code, tag, mark);
            if(result > 0){
                item.setCode(0);
                item.setMsg("打分成功");
            }else{
                item.setCode(-1);
                item.setMsg("打分失败");
            }
        }else{
            item.setCode(-2);
            item.setMsg("查询试卷失败");
        }

        return item;
    }

    /**
     * 查看所有学生试卷
     * */
    @Override
    public ResponseItem<StudentItem> getMarkForStudents(String tag) {
        ResponseItem<StudentItem> item = new ResponseItem<>();
        List<StudentItem> markList = teachDao.getMarkForStudents(tag);
        if(markList != null){
            item.setCode(0);
            item.setMsg("查询成功");
            item.setData(markList);
        }else {
            item.setCode(-1);
            item.setMsg("查询失败");
        }

        return item;
    }
}
