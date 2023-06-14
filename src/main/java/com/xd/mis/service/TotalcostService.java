package com.xd.mis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.entity.Totalcost;

import java.util.List;

public interface TotalcostService extends IService<Totalcost> {
    Page<Totalcost> page(Integer current, Integer size, String dormid);

    Boolean saveOrUpdateById(Totalcost totalcost);

    Boolean deleteBatchIds(List<Integer> ids);
}
