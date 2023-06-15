package com.xd.mis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@Component
public interface PaymentMapper extends BaseMapper<Payment> {

    //根据dormid查询缴费记录并分页
    Page<Payment> getPaymentInfo(@Param("page") Page<Payment> page, @Param("dormid") String dormid);

    //分页列表 根据年月模糊查询宿舍缴费信息
    Page<Payment> getPaymentByDate(@Param("page") Page<Payment> page, @Param("ym") String ym);

}
