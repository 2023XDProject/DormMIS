package com.xd.mis.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.controller.dto.PasswordDto;
import com.xd.mis.controller.dto.UserDto;
import com.xd.mis.entity.Student;
import com.xd.mis.dao.StudentMapper;
import com.xd.mis.exception.ServiceException;
import com.xd.mis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Wrapper;
import java.util.List;

@Service //交由Springboot容器管理
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    private Student getStudentInfo(UserDto userDto){
        LambdaUpdateWrapper<Student> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Student::getStuID,userDto.getUid());
        wrapper.eq(Student::getPwd,userDto.getPwd());
        Student one;
        try{
            one = getOne(wrapper);
        }catch (Exception e){
            log.error(e.toString());
            throw new ServiceException(CodeConstants.CODE_500000,"系统错误");
        }return one;
    }

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

    //修改密码
    @Override
    @Transactional
    public PasswordDto editPassword(PasswordDto pwdDto) {
        UserDto userDto = new UserDto();

//        userDto.setUid(pwdDto.getUid());
//        userDto.setPwd(pwdDto.getOldpwd());
        BeanUtil.copyProperties(pwdDto,userDto,true);
        System.out.println("oldpwd: "+ pwdDto.getOldpwd());
        System.out.println("newpwd: "+ pwdDto.getNewpwd());
        System.out.println("copypwd: "+ userDto.getPwd());
        Student one = getStudentInfo(userDto);

        if(one != null){
            LambdaUpdateWrapper<Student> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.eq(Student::getStuID, pwdDto.getUid()).set(Student::getPwd, pwdDto.getNewpwd());
            studentMapper.update(null, lambdaUpdateWrapper);
        }else throw new ServiceException(CodeConstants.CODE_600000,"用户不存在");
        return pwdDto;
    }

    //注册用户
    @Override
    @Transactional
    public UserDto userRegister(UserDto userDto) {
        Student one = getStudentInfo(userDto);
        if(one == null){
            BeanUtil.copyProperties(userDto,one,true);//忽略大小写
            save(one);
        } else throw new ServiceException(CodeConstants.CODE_600000,"用户已存在");
        return userDto;
    }

    //用户登录
    @Override
    @Transactional
    public UserDto userLogin(UserDto userDto) {
        Student one = getStudentInfo(userDto);
        if(one != null) {
            BeanUtil.copyProperties(one,userDto,true);//忽略大小写
            return userDto;
        } else throw new ServiceException(CodeConstants.CODE_600000,"用户名或密码错误");
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
