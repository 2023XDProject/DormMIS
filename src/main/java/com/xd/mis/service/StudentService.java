package com.xd.mis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xd.mis.entity.Student;

import com.xd.mis.service.StudentService;
import com.xd.mis.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {

    Page<Student> page(Integer current, Integer size, String stuName);

    Boolean saveOrUpdateById(Student student);

    Boolean deleteBatchIds(List<Integer> ids);
}
