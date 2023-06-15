package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.entity.Payment;
import com.xd.mis.dao.PaymentMapper;
import com.xd.mis.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper,Payment> implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    @Transactional
    public Page<Payment> getPaymentInfo(Page<Payment> page, String dormid) {
        return paymentMapper.getPaymentInfo(page,dormid);
    }

    @Override
    public Page<Payment> getPaymentByDate(Page<Payment> page, String year, String month) {
        String ym = year+"-"+month;
        return paymentMapper.getPaymentByDate(page,ym);
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
