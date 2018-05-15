package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;

import com.suke.czx.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.LineDataEntity;
import com.suke.czx.modules.user.service.LineDataService;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;




/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-05-13 09:51:55
 */
@RestController
@RequestMapping("/user/linedata")
public class LineDataController {
    @Autowired
    private LineDataService lineDataService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:linedata:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        if(query.get("openTimeDate")!=null){
            query.put("openTimeDate", DateUtils.parseDate(query.get("openTimeDate").toString(),"yyyy   MMdd"));
            query.put("startDateFrom", DateUtils.parseDate(query.get("startDateFrom").toString(),"yyyyMMdd"));
        }


        List<LineDataEntity> lineDataList = lineDataService.queryList(query);
        int total = lineDataService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(lineDataList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:linedata:info")
    public R info(@PathVariable("id") Integer id){
			LineDataEntity lineData = lineDataService.queryObject(id);

        return R.ok().put("lineData", lineData);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:linedata:save")
    public R save(@RequestBody LineDataEntity lineData){
			lineDataService.save(lineData);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:linedata:update")
    public R update(@RequestBody LineDataEntity lineData){
			lineDataService.update(lineData);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:linedata:delete")
    public R delete(@RequestBody Integer[] ids){
			lineDataService.deleteBatch(ids);

        return R.ok();
    }
	
}
