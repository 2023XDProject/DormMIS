package com.xd.mis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Payment;
import com.xd.mis.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
//    @InitBinder
//    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
//        dateFormat.setLenient(false); //是否严格解析时间 false则严格解析 true宽松解析
//        binder.registerCustomEditor( Date.class, new CustomDateEditor(dateFormat, false));
//    }

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
            @RequestParam(defaultValue = "") String month,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return paymentService.getPaymentByDate(new Page<>(current,size),year,month);
    }

    //充值
    @PostMapping("/recharge") //改变数据库数据就用post
    public boolean ERecharge(@RequestBody Payment payment){
        return paymentService.save(payment);
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
