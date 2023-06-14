package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.entity.Totalcost;
import com.xd.mis.mapper.TotalcostMapper;
import com.xd.mis.service.TotalcostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalcostServiceImpl extends ServiceImpl<TotalcostMapper, Totalcost> implements TotalcostService {
    @Override
    public Page<Totalcost> page(Integer current, Integer size, String dormid) {
        LambdaQueryWrapper<Totalcost> wrapper = new LambdaQueryWrapper<Totalcost>();
        //如果名字不为空
        if(!"".equals(dormid)){
            //模糊查询
            wrapper.like(Totalcost::getDormID,dormid);
        }
        Page<Totalcost> page = page(new Page<>(current,size), wrapper);
        return page;
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
