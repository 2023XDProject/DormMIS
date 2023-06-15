package com.xd.mis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.entity.Student;
import com.xd.mis.entity.DormAdm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DormAdmService {
    Page<Student> getStuByName(Page<Student> page, String stuName);

    Page<Student> selectDormStus(Page<Student> page,String dormid);

    Boolean userRegister(String uid,String pwd);

    Boolean editPassword(String uid,String oldpwd,String newpwd);

    Boolean userLogin(String uid,String pwd);

    Boolean saveOrUpdateById(DormAdm dormAdm);

    Boolean deleteBatchIds(List<Integer> ids);
}
