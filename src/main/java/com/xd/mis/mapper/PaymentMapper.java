package com.xd.mis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Dorm;
import com.xd.mis.entity.Payment;
import com.xd.mis.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentMapper extends BaseMapper<Payment> {

    //根据dormid查询缴费记录并分页
    Page<Payment> getPaymentInfo(@Param("page") Page<Payment> page, @Param("dormid") String dormid);

    //分页列表 根据年月模糊查询宿舍缴费信息
    Page<Payment> getPaymentByDate(@Param("page") Page<Payment> page, @Param("year") String year, @Param("month") String month);

}
