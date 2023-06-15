package com.xd.mis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Totalcost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@Component
public interface TotalcostMapper extends BaseMapper<Totalcost> {

    //分页列表 根据dormid模糊查询历史所有花销
    Page<Totalcost> getAllElectCost(@Param("page") Page<Totalcost> page, @Param("dormid") String dormid);

    //分页列表 根据dormid模糊查询历史所有花销
    Page<Totalcost> getAllWaterCost(@Param("page") Page<Totalcost> page, @Param("dormid") String dormid);

    //分页列表 根据dormid,year,month模糊查询每月花销
    Page<Totalcost> getMonthElectCost(@Param("page") Page<Totalcost> page, @Param("dormid") String dormid, @Param("ym") String ym);

    //分页列表 根据dormid,year,month模糊查询每月花销
    Page<Totalcost> getMonthWaterCost(@Param("page") Page<Totalcost> page, @Param("dormid") String dormid, @Param("ym") String ym);
}
