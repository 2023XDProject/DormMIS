package com.xd.mis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mis.controller.dto.DormDto;
import com.xd.mis.entity.Dorm;
import com.xd.mis.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormService extends IService<Dorm> {

    //根据dormid查询宿舍信息并分页
    Page<Dorm> getDormInfo(Page<Dorm> page, String dormid);

    //根据dormid查询水电费余额并分页
    Page<Dorm> getBalance(Page<Dorm> page, DormDto dormDto);

    Boolean saveOrUpdateById(Dorm dorm);

    Boolean deleteBatchIds(List<Integer> ids);
}
