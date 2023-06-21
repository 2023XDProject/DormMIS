package com.xd.mis.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.entity.Dorm;
import com.xd.mis.mapper.DormMapper;
import com.xd.mis.exception.ServiceException;
import com.xd.mis.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DormServiceImpl extends ServiceImpl<DormMapper, Dorm> implements DormService {

    @Autowired
    DormMapper dormMapper;

    public Dorm getDormInfoByDormDto(String dormid){
        LambdaUpdateWrapper<Dorm> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Dorm::getDormID,dormid);
        Dorm one;
        try{
            one = getOne(wrapper);
        }catch (Exception e){
            log.error(e.toString());
            throw new ServiceException(CodeConstants.CODE_500000,"系统错误");
        }return one;
    }

    //根据dormid查询宿舍信息并分页
    @Override
    @Transactional
    public Page<Dorm> getDormInfo(Page<Dorm> page, String dormid) {
        return dormMapper.getDormInfo(page,dormid);
    }

    //根据dormid查询水电费余额并分页
    @Override
    @Transactional
    public Page<Dorm> getBalance(Page<Dorm> page, String dormid) {
        Dorm one = getDormInfoByDormDto(dormid);
        if(one != null){
            return dormMapper.getBalance(page,dormid);
        }else throw new ServiceException(CodeConstants.CODE_600000,"宿舍不存在");
    }

    @Override
    public Boolean saveOrUpdateById(Dorm dorm) {
        //存在更新记录，否插入一条记录
        return saveOrUpdate(dorm);
    }

    @Override
    public Boolean deleteBatchIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
