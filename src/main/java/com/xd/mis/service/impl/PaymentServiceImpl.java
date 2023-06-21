package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.controller.dto.EchargeDto;
import com.xd.mis.entity.Payment;
import com.xd.mis.mapper.PaymentMapper;
import com.xd.mis.entity.Student;
import com.xd.mis.exception.ServiceException;
import com.xd.mis.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper,Payment> implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Autowired
    StudentServiceImpl studentService;

    @Override
    @Transactional
    public Page<Payment> getPaymentInfo(Page<Payment> page, String dormid) {
        return paymentMapper.getPaymentInfo(page,dormid);
    }

    @Override
    @Transactional
    public Page<Payment> getPaymentByDate(Page<Payment> page, String year, String month) {
        String ym = year+"-"+month;
        return paymentMapper.getPaymentByDate(page,ym);
    }

    @Override
    @Transactional
    public EchargeDto ERecharge(EchargeDto echargeDto) {
        Student one = studentService.getStudentInfoByStuID(echargeDto.getStuID());
        if(one != null) {
            Payment payment = new Payment();
            payment.setDormID(echargeDto.getDormID());
            payment.setStuID(echargeDto.getStuID());
            payment.setEBill(echargeDto.getEbill());
            payment.setPDateTime(echargeDto.getPDateTime());
            save(payment);
            return echargeDto;
        } else throw new ServiceException(CodeConstants.CODE_600000,"用户名或密码错误");
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateById(Payment payment) {
        //存在更新记录，否插入一条记录
        return saveOrUpdate(payment);
    }

    @Override
    @Transactional
    public Boolean deleteBatchIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
