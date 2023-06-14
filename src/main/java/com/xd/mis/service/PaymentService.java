package com.xd.mis.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.entity.Payment;

import java.util.List;

public interface PaymentService extends IService<Payment> {
    Page<Payment> page(Integer current, Integer size, String dormid);

    Boolean saveOrUpdateById(Payment payment);

    Boolean deleteBatchIds(List<Integer> ids);
}
