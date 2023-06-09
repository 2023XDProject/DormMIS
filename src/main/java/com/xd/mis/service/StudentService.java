package com.xd.mis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.controller.dto.PasswordDto;
import com.xd.mis.controller.dto.StudentDto;
import com.xd.mis.controller.dto.UserDto;
import com.xd.mis.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentService extends IService<Student> {

    Page<Student> getStuByID(Page<Student> page, String stuid);

    Page<Student> selectDormStus(Page<Student> page,String dormid);

    StudentDto userRegister(StudentDto studentDto);

    PasswordDto editPassword(PasswordDto pwdDto);

    StudentDto userLogin(StudentDto studentDto);

    Boolean saveOrUpdateById(Student student);

    Boolean deleteBatchIds(List<Integer> ids);
}
