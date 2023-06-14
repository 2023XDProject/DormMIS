package com.xd.mis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xd.mis.entity.Totalcost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TotalcostMapper extends BaseMapper<Totalcost> {
}
