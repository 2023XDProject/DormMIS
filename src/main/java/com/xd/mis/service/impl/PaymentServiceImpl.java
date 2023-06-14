package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.entity.Payment;
import com.xd.mis.mapper.PaymentMapper;
import com.xd.mis.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper,Payment> implements PaymentService {
    @Override
    public Page<Payment> pageByPayment(Integer current, Integer size, String dormid) {
        LambdaQueryWrapper<Payment> wrapper = new LambdaQueryWrapper<Payment>();
        //如果名字不为空
        if(!"".equals(dormid)){
            //模糊查询
            wrapper.like(Payment::getDormID,dormid);
        }
        Page<Payment> page = page(new Page<>(current,size), wrapper);
        return page;
    }

    @Override
    public Boolean saveOrUpdateById(Payment payment) {
        //存在更新记录，否插入一条记录
        return saveOrUpdate(payment);
    }

    @Override
    public Boolean deleteBatchIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
