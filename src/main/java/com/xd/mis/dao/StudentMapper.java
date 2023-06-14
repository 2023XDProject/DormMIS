package com.xd.mis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper //告诉springboot这是一个mybatis的mapper类
@Repository //将StudentMapper交给spring容器管理
@Component
public interface StudentMapper extends BaseMapper<Student> {

    //根据stuid查询学生个人信息并分页
    Page<Student> getStuById(@Param("page") Page<Student> page,@Param("stuid") String stuid);

    //根据stuname查询学生个人信息并分页
    Page<Student> getStuByName(@Param("page") Page<Student> page,@Param("stuname") String stuname);

    //根据dormid查询宿舍人员名单并分页
    Page<Student> getStuByDormid(@Param("page") Page<Student> page,@Param("dormid") String dormid);

    //注册用户
    Boolean userRegister(@Param("user") Student user);

    //判断用户是否存在
    Boolean checkUserExist(@Param("uid") String uid);

    //用户登陆
    Boolean userLogin(@Param("uid") String uid,@Param("pwd") String pwd);

}
