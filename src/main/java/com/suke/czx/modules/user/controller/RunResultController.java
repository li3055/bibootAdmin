package com.suke.czx.modules.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.suke.czx.common.utils.*;
import com.suke.czx.modules.user.entity.RunResultEntity;
import com.suke.czx.modules.user.service.RunResultService;
import net.sf.json.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author czx
 * @email object_czx@163.com
 * @date 2018-02-05 16:01:38
 */
@RestController
@RequestMapping("/user/runresult")
public class RunResultController {
    @Autowired
    private RunResultService runResultService;

    static int  runId =0;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:runresult:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RunResultEntity> runResultList = new ArrayList<>();
        int total = 4;
        String symbol = query.get("symbol").toString();
        if (StringUtils.isEmpty(symbol)) {
            PageUtils pageUtil = new PageUtils(runResultList, total, query.getLimit(), query.getPage());
            return R.ok().put("page", pageUtil);
        }
        for (int i = 0; i < 4; i++) {
            StringBuffer bf = new StringBuffer("http://localhost:8800/backtest/single?");
            Date start = null;
            Date end = null;
            if (i == 0) {
                start = DateUtils.parseDate("2018-01-01 02:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-01-17 12:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");
            } else if (i == 1) {
                start = DateUtils.parseDate("2018-01-17 12:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-02-06 14:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");
            } else if (i == 2) {
                start = DateUtils.parseDate("2018-01-28 02:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-02-06 14:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");
            } else {
                start = DateUtils.parseDate("2018-02-02 02:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-02-06 14:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");
            }


            String trailingBuy = query.get("trailingBuy").toString();
            String buyValue = query.get("buyValue").toString();
            String sellValue = query.get("sellValue").toString();
            String trailingProfit = query.get("trailingProfit").toString();


            bf.append("symbol=").append(symbol).append("&");
            bf.append("trailingBuy=").append(trailingBuy).append("&");
            bf.append("buyValue=").append(buyValue).append("&");
            bf.append("sellValue=").append(sellValue).append("&");
            bf.append("trailingProfit=").append(trailingProfit);
            Object single = CHttpRequest.sendPost(bf.toString(), "");
//        JSONObject single = CHttpRequest.httpRequest("http://localhost:8800/backtest", "single");
            System.err.println(single);
            RunResultEntity resultOBj = com.alibaba.fastjson.JSON.parseObject(single.toString(), RunResultEntity.class);
            resultOBj.setStartdate(start);
            resultOBj.setEnddate(end);
            runResultList.add(resultOBj);
        }

        PageUtils pageUtil = new PageUtils(runResultList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }




    @RequestMapping("/list2/{id}")
    public ModelAndView list2(@PathVariable("id") String id) {
        System.out.println("id= "+id);
        runId = Integer.parseInt(id);
        ModelAndView mv = new ModelAndView("redirect:http://localhost:8080/x_springboot/index.html#modules/user/runresult.html");

        return  mv;
       // return "/user/runresult/runresult.html";
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:runresult:info")
    public R info(@PathVariable("id") Integer id) {
        RunResultEntity runResult = runResultService.queryObject(id);

        return R.ok().put("runResult", runResult);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:runresult:save")
    public R save(@RequestBody RunResultEntity runResult) {
        runResultService.save(runResult);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:runresult:update")
    public R update(@RequestBody RunResultEntity runResult) {
        runResultService.update(runResult);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:runresult:delete")
    public R delete(@RequestBody Integer[] ids) {
        runResultService.deleteBatch(ids);

        return R.ok();
    }

}
