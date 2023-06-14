package com.xd.mis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xd.mis.entity.Dorm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DormMapper extends BaseMapper<Dorm> {
}
