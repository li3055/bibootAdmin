package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;

import com.suke.czx.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.KkOrderEntity;
import com.suke.czx.modules.user.service.KkOrderService;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;




/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-05-13 09:49:11
 */
@RestController
@RequestMapping("/user/kkorder")
public class KkOrderController {
    @Autowired
    private KkOrderService kkOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:kkorder:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<KkOrderEntity> kkOrderList = kkOrderService.queryList(query);
        int total = kkOrderService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(kkOrderList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:kkorder:info")
    public R info(@PathVariable("id") Integer id){
			KkOrderEntity kkOrder = kkOrderService.queryObject(id);

        return R.ok().put("kkOrder", kkOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:kkorder:save")
    public R save(@RequestBody KkOrderEntity kkOrder){
			kkOrderService.save(kkOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:kkorder:update")
    public R update(@RequestBody KkOrderEntity kkOrder){
			kkOrderService.update(kkOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:kkorder:delete")
    public R delete(@RequestBody Integer[] ids){
			kkOrderService.deleteBatch(ids);

        return R.ok();
    }
	
}
