package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.entity.DormAdm;
import com.xd.mis.dao.DormAdmMapper;
import com.xd.mis.service.DormAdmService;
import com.xd.mis.entity.Student;
import com.xd.mis.dao.StudentMapper;
import com.xd.mis.service.StudentService;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Wrapper;
import java.util.List;

@Service //交由Springboot容器管理

public class DormAdmServiceImpl extends ServiceImpl<DormAdmMapper,DormAdm> implements DormAdmService{
    @Autowired
    StudentMapper studentMapper;
    DormAdmMapper dormAdmMapper;

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
    @Transactional
    public Boolean userRegister(String uid,String pwd) {
        DormAdm user = new DormAdm();
        user.setDormAdmID(uid);
        user.setPwd(pwd);
        return save(user);
    }

    //修改密码
    @Override
    @Transactional
    public Boolean editPassword(String uid, String oldpwd, String newpwd) {
        LambdaUpdateWrapper<DormAdm> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(DormAdm::getDormAdmID, uid).set(DormAdm::getPwd, newpwd);

        Integer rows = dormAdmMapper.update(null, lambdaUpdateWrapper);
        if(rows >= 1) return true;
        else return false;
    }

    //用户登录
    @Override
    @Transactional
    public Boolean userLogin(String uid, String pwd) {
        return studentMapper.userLogin(uid,pwd);
    }

    @Override
    public Boolean saveOrUpdateById(DormAdm dormAdm) {
        //存在更新记录，否插入一条记录
        return saveOrUpdate(dormAdm);
    }

    @Override
    public Boolean deleteBatchIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }

}
