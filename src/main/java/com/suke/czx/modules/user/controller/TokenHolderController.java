package com.suke.czx.modules.user.controller;

import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.user.entity.TokenHolderEntity;
import com.suke.czx.modules.user.service.TokenHolderService;
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
 * @date 2018-03-07 14:19:55
 */
@RestController
@RequestMapping("/user/tokenholder")
public class TokenHolderController {
    @Autowired
    private TokenHolderService tokenHolderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:tokenholder:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<TokenHolderEntity> tokenHolderList = tokenHolderService.queryList(query);
        int total = tokenHolderService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(tokenHolderList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:tokenholder:info")
    public R info(@PathVariable("id") Integer id){
			TokenHolderEntity tokenHolder = tokenHolderService.queryObject(id);

        return R.ok().put("tokenHolder", tokenHolder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:tokenholder:save")
    public R save(@RequestBody TokenHolderEntity tokenHolder){
			tokenHolderService.save(tokenHolder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:tokenholder:update")
    public R update(@RequestBody TokenHolderEntity tokenHolder){
			tokenHolderService.update(tokenHolder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:tokenholder:delete")
    public R delete(@RequestBody Integer[] ids){
			tokenHolderService.deleteBatch(ids);

        return R.ok();
    }
	
}
