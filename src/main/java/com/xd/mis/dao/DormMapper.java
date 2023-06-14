package com.xd.mis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Dorm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DormMapper extends BaseMapper<Dorm> {

    //根据dormid查询宿舍信息并分页
    Page<Dorm> getDormInfo(@Param("page") Page<Dorm> page, @Param("dormid") String dormid);

    //根据dormid查询水电费余额并分页
    Page<Dorm> getBalance(@Param("page") Page<Dorm> page, @Param("dormid") String dormid);
}
