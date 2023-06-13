package com.xd.mis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xd.mis.entity.Student;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //告诉springboot这是一个mybatis的mapper类
@Repository //将StudentMapper交给spring容器管理
public interface StudentMapper extends BaseMapper<Student> {

}
