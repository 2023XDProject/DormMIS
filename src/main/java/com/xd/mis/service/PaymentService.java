package com.xd.mis.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Payment;
import com.xd.mis.entity.Student;

import java.util.List;

public interface PaymentService {
    Page<Payment> page(Integer current, Integer size, String dormid);

    Boolean saveOrUpdateById(Payment payment);

    Boolean deleteBatchIds(List<Integer> ids);
}
