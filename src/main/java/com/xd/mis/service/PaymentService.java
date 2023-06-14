package com.xd.mis.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService extends IService<Payment> {

    //根据dormid查询缴费记录并分页
    Page<Payment> getPaymentInfo(Page<Payment> page, String dormid);

    //分页列表 根据年月模糊查询宿舍缴费信息
    Page<Payment> getPaymentByDate(Page<Payment> page, String year,String month);

    Boolean saveOrUpdateById(Payment payment);

    Boolean deleteBatchIds(List<Integer> ids);
}
