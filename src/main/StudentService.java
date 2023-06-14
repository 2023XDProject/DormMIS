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

    void userRegister(Student user);

    Boolean checkUserExist(String uid);

    Boolean userLogin(String uid,String password);

    Boolean userChangePassword(String uid,String oldPassword,String newPassword);

    Boolean userForgetPassword(String uid,String mail,String securityCode);

    Boolean saveOrUpdateById(Student student);

    Boolean deleteBatchIds(List<Integer> ids);
}
