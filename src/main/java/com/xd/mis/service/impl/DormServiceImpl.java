package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.entity.Dorm;
import com.xd.mis.entity.Student;
import com.xd.mis.mapper.DormMapper;
import com.xd.mis.service.DormService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormServiceImpl extends ServiceImpl<DormMapper, Dorm> implements DormService {
    @Override
    public Page<Dorm> page(Integer current, Integer size, String dormid) {
        LambdaQueryWrapper<Dorm> wrapper = new LambdaQueryWrapper<Dorm>();
        //如果名字不为空
        if(!"".equals(dormid)){
            //模糊查询
            wrapper.like(Dorm::getDormID,dormid);
        }
        Page<Dorm> page = page(new Page<>(current,size), wrapper);
        return page;
    }

    @Override
    public Boolean saveOrUpdateById(Dorm dorm) {
        //存在更新记录，否插入一条记录
        return saveOrUpdate(dorm);
    }

    @Override
    public Boolean deleteBatchIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
