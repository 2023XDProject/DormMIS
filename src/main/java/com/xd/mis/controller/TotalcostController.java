package com.xd.mis.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.common.Result;
import com.xd.mis.entity.Dorm;
import com.xd.mis.entity.Totalcost;
import com.xd.mis.service.impl.DormServiceImpl;
import com.xd.mis.service.impl.TotalcostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/totalcost")
public class TotalcostController {

    @Autowired
    private TotalcostServiceImpl totalcostService;

//    @InitBinder
//    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
//        dateFormat.setLenient(false); //是否严格解析时间 false则严格解析 true宽松解析
//        binder.registerCustomEditor( Date.class, new CustomDateEditor(dateFormat, false));
//    }

    //分页列表 根据dormid模糊查询历史所有电费
    @GetMapping("/allelec") //不改变数据库数据就用get
    public Result getAllElectCost(@RequestParam String dormid){
        if(StrUtil.isBlank(dormid)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(totalcostService.getAllElectCost(new Page<>(1,5),dormid));
    }

    //分页列表 根据dormid模糊查询历史所有水费
    @GetMapping("/allwater") //不改变数据库数据就用get
    public Result getAllWaterCost(@RequestParam String dormid){
        if(StrUtil.isBlank(dormid)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(totalcostService.getAllWaterCost(new Page<>(1,5),dormid));
    }

    //分页列表 根据dormid,year,month模糊查询每月电费
    @GetMapping("/monthelec") //不改变数据库数据就用get
    public Page<Totalcost> getMonthElectCost(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "") String year,
            @RequestParam(defaultValue = "") String month,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return totalcostService.getMonthElectCost(new Page<>(current,size),dormid,year,month);
    }

    //分页列表 根据dormid,year,month模糊查询每月水费
    @GetMapping("/monthwater") //不改变数据库数据就用get
    public Page<Totalcost> getMonthWaterCost(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "") String year,
            @RequestParam(defaultValue = "") String month,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return totalcostService.getMonthWaterCost(new Page<>(current,size),dormid,year,month);
    }

    /**
     * 数据保存和新增
     * @param totalcost
     * @return
     */
    @PostMapping("/update") //改变数据库数据就用post
    public boolean saveOrUpdateById(@RequestBody Totalcost totalcost){
        return totalcostService.saveOrUpdateById(totalcost);
    }

    /**
     * 单选删除和批量删除
     * @param ids
     * @return
     */
    @PostMapping("/delete") //改变数据库数据就用post
    public boolean delete(@RequestBody List<Integer> ids){
        return totalcostService.deleteBatchIds(ids);
    }
}
