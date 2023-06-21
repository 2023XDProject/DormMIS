package com.xd.mis.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.entity.Dorm;
import com.xd.mis.entity.Student;
import com.xd.mis.entity.Totalcost;
import com.xd.mis.exception.ServiceException;
import com.xd.mis.mapper.TotalcostMapper;
import com.xd.mis.service.DormService;
import com.xd.mis.service.TotalcostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TotalcostServiceImpl extends ServiceImpl<TotalcostMapper, Totalcost> implements TotalcostService {

    @Autowired
    TotalcostMapper totalcostMapper;

    public Totalcost getCostInfoByDormid(String dormid){
        LambdaUpdateWrapper<Totalcost> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Totalcost::getDormID,dormid);
        Totalcost one;
        try{
            one = getOne(wrapper);
        }catch (Exception e){
            log.error(e.toString());
            throw new ServiceException(CodeConstants.CODE_500000,"系统错误");
        }return one;
    }

    //分页列表 根据dormid模糊查询历史所有电费
    @Override
    @Transactional
    public Page<Totalcost> getAllElectCost(Page<Totalcost> page, String dormid) {
        Totalcost one = getCostInfoByDormid(dormid);
        if(one != null) {
            return totalcostMapper.getAllElectCost(page,dormid);
        } else throw new ServiceException(CodeConstants.CODE_600000,"用户名或密码错误");
    }

    //分页列表 根据dormid模糊查询历史所有水费
    @Override
    @Transactional
    public Page<Totalcost> getAllWaterCost(Page<Totalcost> page, String dormid) {
        Totalcost one = getCostInfoByDormid(dormid);
        if(one != null) {
            return totalcostMapper.getAllWaterCost(page,dormid);
        } else throw new ServiceException(CodeConstants.CODE_600000,"用户名或密码错误");
    }

    //分页列表 根据dormid,year,month模糊查询每月水费
    @Override
    public Page<Totalcost> getMonthElectCost(Page<Totalcost> page, String dormid, String year,String month) {
        String ym = year+"-"+month;
        return totalcostMapper.getMonthElectCost(page,dormid,ym);
    }

    //分页列表 根据dormid,year,month模糊查询每月电费
    @Override
    public Page<Totalcost> getMonthWaterCost(Page<Totalcost> page, String dormid, String year,String month) {
        String ym = year+"-"+month;
        return totalcostMapper.getMonthWaterCost(page,dormid,ym);
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
