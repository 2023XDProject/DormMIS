package com.xd.mis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.entity.Dorm;

import java.util.List;

public interface DormService extends IService<Dorm> {

    Page<Dorm> page(Integer current, Integer size, String dormid);

    Boolean saveOrUpdateById(Dorm dorm);

    Boolean deleteBatchIds(List<Integer> ids);
}
