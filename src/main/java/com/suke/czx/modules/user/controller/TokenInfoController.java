package com.suke.czx.modules.user.controller;

import com.suke.czx.common.utils.DateUtils;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.user.entity.TokenInfoEntity;
import com.suke.czx.modules.user.service.TokenInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
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
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        if (query.get("symbol") != null) {
            List<TokenInfoEntity> tokenInfoList = tokenInfoService.queryList(query);
            int total = tokenInfoService.queryTotal(query);

            PageUtils pageUtil = new PageUtils(tokenInfoList, total, query.getLimit(), query.getPage());
            return R.ok().put("page", pageUtil);

        } else {
            Integer today = Integer.parseInt(DateUtils.format(new Date(), "yyyyMMdd"));
            query.put("collectDateInt", 20180403);

            List<TokenInfoEntity> tokenInfoList = tokenInfoService.queryList(query);


            Date startDate = DateUtils.addDays(new Date(), -5);
            Integer bijiaoDay = Integer.parseInt(DateUtils.format(startDate, "yyyyMMdd"));
            query.put("collectDateInt", 20180313);

            List<TokenInfoEntity> oldList = tokenInfoService.queryList(query);

            for (TokenInfoEntity tokenInfoEntity : tokenInfoList) {

                for (TokenInfoEntity oldRecord : oldList) {
                    if (oldRecord.getSymbol().equals(tokenInfoEntity.getSymbol())) {
                        tokenInfoEntity.setPre50D1(tokenInfoEntity.getPre50Percent() - oldRecord.getPre50Percent());
                        tokenInfoEntity.setPre100D1(tokenInfoEntity.getPre100Percent() - oldRecord.getPre100Percent());
                        tokenInfoEntity.setPre150D1(tokenInfoEntity.getPre150Percent() - oldRecord.getPre150Percent());
                        tokenInfoEntity.setPre200D1(tokenInfoEntity.getPre200Percent() - oldRecord.getPre200Percent());
                        tokenInfoEntity.setPre250D1(tokenInfoEntity.getPre250Percent() - oldRecord.getPre250Percent());
                        tokenInfoEntity.setPre300D1(tokenInfoEntity.getPre300Percent() - oldRecord.getPre300Percent());
                    }
                }
            }
            int total = 15000;
            PageUtils pageUtil = new PageUtils(tokenInfoList, total, query.getLimit(), query.getPage());
            return R.ok().put("page", pageUtil);
        }


    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:tokeninfo:info")
    public R info(@PathVariable("id") Integer id) {
        TokenInfoEntity tokenInfo = tokenInfoService.queryObject(id);

        return R.ok().put("tokenInfo", tokenInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:tokeninfo:save")
    public R save(@RequestBody TokenInfoEntity tokenInfo) {
        tokenInfoService.save(tokenInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:tokeninfo:update")
    public R update(@RequestBody TokenInfoEntity tokenInfo) {
        tokenInfoService.update(tokenInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:tokeninfo:delete")
    public R delete(@RequestBody Integer[] ids) {
        tokenInfoService.deleteBatch(ids);

        return R.ok();
    }

}
