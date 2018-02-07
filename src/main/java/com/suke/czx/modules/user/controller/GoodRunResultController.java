package com.suke.czx.modules.user.controller;

import com.suke.czx.common.contants.BibootAdminConstant;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.user.entity.GoodRunResultEntity;
import com.suke.czx.modules.user.service.GoodRunResultService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;




/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-02-04 09:11:43
 */
@RestController
@RequestMapping("/user/goodrunresult")
public class GoodRunResultController {
    @Autowired
    private GoodRunResultService goodRunResultService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:goodrunresult:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
       // params.put("strategyName","SMAspread2018-01-01 01:00:00");
        Query query = new Query(params);

        List<GoodRunResultEntity> goodRunResultList = goodRunResultService.queryList(query);
        int total = 5000;
//        int total = goodRunResultService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(goodRunResultList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:goodrunresult:info")
    public R info(@PathVariable("id") Integer id){
			GoodRunResultEntity goodRunResult = goodRunResultService.queryObject(id);

        return R.ok().put("goodRunResult", goodRunResult);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:goodrunresult:save")
    public R save(@RequestBody GoodRunResultEntity goodRunResult){
			goodRunResultService.save(goodRunResult);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:goodrunresult:update")
    public R update(@RequestBody GoodRunResultEntity goodRunResult){
			goodRunResultService.update(goodRunResult);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:goodrunresult:delete")
    public R delete(@RequestBody Integer[] ids){
			//goodRunResultService.deleteBatch(ids);
        udpateByRunResult(ids[0]);

        return R.ok();
    }

    public void udpateByRunResult(int id ) {
        goodRunResultService.udpateByRunResult(id, BibootAdminConstant.NIU);

    }
	
}
