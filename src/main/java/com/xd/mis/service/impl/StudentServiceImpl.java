package com.xd.mis.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.controller.dto.PasswordDto;
import com.xd.mis.controller.dto.StudentDto;
import com.xd.mis.entity.Student;
import com.xd.mis.mapper.StudentMapper;
import com.xd.mis.exception.ServiceException;
import com.xd.mis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //交由Springboot容器管理
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    public Student getStudentInfoByStuIDpwd(StudentDto studentDto){
        LambdaUpdateWrapper<Student> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Student::getStuID,studentDto.getStuID());
        wrapper.eq(Student::getPwd,studentDto.getPwd());
        Student one;
        try{
            one = getOne(wrapper);
        }catch (Exception e){
            log.error(e.toString());
            throw new ServiceException(CodeConstants.CODE_500000,"系统错误");
        }return one;
    }

    public Student getStudentInfoByStuID(String stuid){
        LambdaUpdateWrapper<Student> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Student::getStuID,stuid);
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
    public Page<Student> getStuByID(Page<Student> page, String stuid) {
        Student one = getStudentInfoByStuID(stuid);
        if(one != null){
            return studentMapper.getStuByID(page,stuid);
        }else throw new ServiceException(CodeConstants.CODE_600000,"用户不存在");
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
        StudentDto stuDto = new StudentDto();

        stuDto.setStuID(pwdDto.getUid());
        stuDto.setPwd(pwdDto.getOldpwd());
        Student one = getStudentInfoByStuIDpwd(stuDto);

        if(one != null){
            LambdaUpdateWrapper<Student> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.eq(Student::getStuID, pwdDto.getUid()).set(Student::getPwd, pwdDto.getNewpwd());
            studentMapper.update(null, lambdaUpdateWrapper);
            return pwdDto;
        }else throw new ServiceException(CodeConstants.CODE_600000,"用户不存在");
    }

    //注册用户
    @Override
    @Transactional
    public StudentDto userRegister(StudentDto studentDto) {
        Student one = getStudentInfoByStuIDpwd(studentDto);
        if(one == null){
            Student newStu = new Student();
            newStu.setStuID(studentDto.getStuID());
            newStu.setPwd(studentDto.getPwd());
            save(newStu);
            return studentDto;
        } else throw new ServiceException(CodeConstants.CODE_600000,"用户已存在");
    }

    //用户登录
    @Override
    @Transactional
    public StudentDto userLogin(StudentDto studentDto) {
        Student one = getStudentInfoByStuIDpwd(studentDto);
        if(one != null) {
            BeanUtil.copyProperties(one,studentDto,true);//忽略大小写
            return studentDto;
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
