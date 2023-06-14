package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.entity.Dorm;
import com.xd.mis.entity.Totalcost;
import com.xd.mis.mapper.DormMapper;
import com.xd.mis.mapper.TotalcostMapper;
import com.xd.mis.service.TotalcostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalcostServiceImpl extends ServiceImpl<TotalcostMapper, Totalcost> implements TotalcostService {

    @Autowired
    TotalcostMapper totalcostMapper;

    //分页列表 根据dormid模糊查询历史所有电费
    @Override
    public Page<Totalcost> getAllElectCost(Page<Totalcost> page, String dormid) {
        return totalcostMapper.getAllElectCost(page,dormid);
    }

    //分页列表 根据dormid模糊查询历史所有水费
    @Override
    public Page<Totalcost> getAllWatherCost(Page<Totalcost> page, String dormid) {
        return totalcostMapper.getAllWatherCost(page,dormid);
    }

    //分页列表 根据dormid,year,month模糊查询每月水费
    @Override
    public Page<Totalcost> getMonthElectCost(Page<Totalcost> page, String dormid, String year,String month) {
        return totalcostMapper.getMonthElectCost(page,dormid,year,month);
    }

    //分页列表 根据dormid,year,month模糊查询每月电费
    @Override
    public Page<Totalcost> getMonthWatherCost(Page<Totalcost> page, String dormid, String year,String month) {
        return totalcostMapper.getMonthWatherCost(page,dormid,year,month);
    }

    @Override
    public Boolean saveOrUpdateById(Totalcost totalcost) {
        //存在更新记录，否插入一条记录
        return saveOrUpdate(totalcost);
    }

    @Override
    public Boolean deleteBatchIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
