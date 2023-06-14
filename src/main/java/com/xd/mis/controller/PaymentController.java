package com.xd.mis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Payment;
import com.xd.mis.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentService;

    //分页列表 模糊查询宿舍缴费信息
    @GetMapping("/dorm") //不改变数据库数据就用get
    public Page<Payment> pageByPayment(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return paymentService.getPaymentInfo(new Page<>(current,size),dormid);
    }

    /**
     * 数据保存和新增
     * @param payment
     * @return
     */
    @PostMapping("/update") //改变数据库数据就用post
    public boolean saveOrUpdateById(@RequestBody Payment payment){
        return paymentService.saveOrUpdateById(payment);
    }

    /**
     * 单选删除和批量删除
     * @param ids
     * @return
     */
    @PostMapping("/delete") //改变数据库数据就用post
    public boolean delete(@RequestBody List<Integer> ids){
        return paymentService.deleteBatchIds(ids);
    }
}
