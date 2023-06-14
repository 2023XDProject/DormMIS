package com.xd.mis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Totalcost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TotalcostMapper extends BaseMapper<Totalcost> {

    //分页列表 根据dormid模糊查询历史所有花销
    public Page<Totalcost> getAllElectCost(Page<Totalcost> page, String dormid);

    //分页列表 根据dormid模糊查询历史所有花销
    public Page<Totalcost> getAllWatherCost(Page<Totalcost> page, String dormid);

    //分页列表 根据dormid,year,month模糊查询每月花销
    public Page<Totalcost> getMonthElectCost(Page<Totalcost> page, String dormid, String year,String month);

    //分页列表 根据dormid,year,month模糊查询每月花销
    public Page<Totalcost> getMonthWatherCost(Page<Totalcost> page, String dormid, String year,String month);
}
