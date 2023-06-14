package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.entity.Student;
import com.xd.mis.mapper.StudentMapper;
import com.xd.mis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //交由Springboot容器管理
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    //根据stuname查询学生个人信息并分页
    @Override
    @Transactional
    public Page<Student> getStuByName(Page<Student> page, String stuName) {
        return studentMapper.getStuByName(page,stuName);
    }

    //根据dormid查询住宿人员名单并分页
    @Override
    @Transactional
    public Page<Student> selectDormStus(Page<Student> page,String dormid) {
        return studentMapper.getStuByDormid(page,dormid);
    }

    //注册用户
    @Override
    public void userRegister(Student user) {
        save(user);
    }

    //判断用户是否存在
    @Override
    public Boolean checkUserExist(String uid) {
        return studentMapper.checkUserExist(uid);
    }

    @Override
    public Boolean userLogin(String uid, String password) {
        return studentMapper.userLogin(uid,password);
    }

    @Override
    public Boolean saveOrUpdateById(Student student) {
        //存在更新记录，否插入一条记录
        return saveOrUpdate(student);
    }

    @Override
    public Boolean deleteBatchIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
