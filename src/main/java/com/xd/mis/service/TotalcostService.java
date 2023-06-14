package com.xd.mis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.entity.Dorm;
import com.xd.mis.entity.Totalcost;

import java.util.List;

public interface TotalcostService extends IService<Totalcost> {
    //分页列表 根据dormid模糊查询历史所有电费
    Page<Totalcost> getAllElectCost(Page<Totalcost> page, String dormid);

    //分页列表 根据dormid模糊查询历史所有水费
    Page<Totalcost> getAllWatherCost(Page<Totalcost> page, String dormid);

    //分页列表 根据dormid,year,month模糊查询每月花销
    Page<Totalcost> getMonthElectCost(Page<Totalcost> page, String dormid, String year,String month);

    //分页列表 根据dormid,year,month模糊查询每月花销
    Page<Totalcost> getMonthWatherCost(Page<Totalcost> page, String dormid, String year,String month);

    Boolean saveOrUpdateById(Totalcost totalcost);

    Boolean deleteBatchIds(List<Integer> ids);
}
