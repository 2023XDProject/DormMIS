package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.entity.Student;
import com.xd.mis.mapper.StudentMapper;
import com.xd.mis.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //交由Springboot容器管理
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Override
    public Page<Student> pageByName(Integer current, Integer size, String stuName) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<Student>();
        //如果名字不为空
        if(!"".equals(stuName)){
            //模糊查询
            wrapper.like(Student::getStuName,stuName);
        }
        Page<Student> page = page(new Page<>(current,size), wrapper);
        return page;
    }

    @Override
    public Page<Student> pageByDorm(Integer current, Integer size, String dormid) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<Student>();
        //如果名字不为空
        if(!"".equals(dormid)){
            //模糊查询
            wrapper.like(Student::getDormID,dormid);
        }
        Page<Student> page = page(new Page<>(current,size), wrapper);
        return page;
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
