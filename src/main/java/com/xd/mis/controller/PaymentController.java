package com.xd.mis.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.common.Result;
import com.xd.mis.controller.dto.EchargeDto;
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
    @GetMapping("/dorm")
    public Page<Payment> getPaymentInfo(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return paymentService.getPaymentInfo(new Page<>(current,size),dormid);
    }

    //分页列表 根据年月模糊查询宿舍缴费信息
    @GetMapping("/date")
    public Page<Payment> getPaymentByDate(
            @RequestParam(defaultValue = "") String year,
            @RequestParam(defaultValue = "") String month){
        return paymentService.getPaymentByDate(new Page<>(1,5),year,month);
    }

    //充电费
    @PostMapping("/erecharge")
    public Result ERecharge(@RequestBody EchargeDto echargeDto){
        String dormid = echargeDto.getDormID();
        String stuid = echargeDto.getStuID();
        Integer ebill = echargeDto.getEbill();

        if(StrUtil.isBlank(dormid) || StrUtil.isBlank(stuid)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(paymentService.ERecharge(echargeDto));
    }

    //充水费
//    @PostMapping("/wrecharge")
//    public Result WRecharge(PaymentDto paymentDto){
//        String dormid = paymentDto.getDormID();
//        String stuid = paymentDto.getStuID();
//        Double wbill = paymentDto.getWBill();
//        Double ebill = Double.valueOf(0);
//
//        if(StrUtil.isBlank(dormid) || StrUtil.isBlank(stuid)
//                || wbill == null) {
//            return Result.error(CodeConstants.CODE_400000,"参数错误");
//        }
//        return Result.success(paymentService.);
//    }

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
