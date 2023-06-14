package com.xd.mis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {

    Page<Student> pageByName(Integer current, Integer size, String stuName);

    Page<Student> pageByDorm(Integer current, Integer size, String dormid);

    Boolean saveOrUpdateById(Student student);

    Boolean deleteBatchIds(List<Integer> ids);
}
