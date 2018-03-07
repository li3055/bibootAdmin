package com.suke.czx.modules.user.controller;

import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.user.entity.TokenInfoEntity;
import com.suke.czx.modules.user.service.TokenInfoService;
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
@RequestMapping("/user/tokeninfo")
public class TokenInfoController {
    @Autowired
    private TokenInfoService tokenInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:tokeninfo:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<TokenInfoEntity> tokenInfoList = tokenInfoService.queryList(query);
        int total = tokenInfoService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(tokenInfoList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:tokeninfo:info")
    public R info(@PathVariable("id") Integer id){
			TokenInfoEntity tokenInfo = tokenInfoService.queryObject(id);

        return R.ok().put("tokenInfo", tokenInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:tokeninfo:save")
    public R save(@RequestBody TokenInfoEntity tokenInfo){
			tokenInfoService.save(tokenInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:tokeninfo:update")
    public R update(@RequestBody TokenInfoEntity tokenInfo){
			tokenInfoService.update(tokenInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:tokeninfo:delete")
    public R delete(@RequestBody Integer[] ids){
			tokenInfoService.deleteBatch(ids);

        return R.ok();
    }
	
}
