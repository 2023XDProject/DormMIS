package com.xd.mis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentService extends IService<Student> {

    Page<Student> getStuByName(Page<Student> page, String stuName);

    Page<Student> selectDormStus(Page<Student> page,String dormid);

    Boolean saveOrUpdateById(Student student);

    Boolean deleteBatchIds(List<Integer> ids);
}
