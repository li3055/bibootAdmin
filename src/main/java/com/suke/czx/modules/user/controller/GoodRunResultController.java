package com.suke.czx.modules.user.controller;

import com.suke.czx.common.utils.*;
import com.suke.czx.modules.user.entity.GoodRunResultEntity;
import com.suke.czx.modules.user.service.GoodRunResultService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
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
        params.put("strategyName","SMAspread2018-01-01 01:00:00");
        Query query = new Query(params);

        List<GoodRunResultEntity> goodRunResultList = goodRunResultService.queryList(query);
        int total = 3000;
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

        GoodRunResultEntity runResult = goodRunResultService.queryObject(id);
        String[] changeParams = {"max_cost_percentage", "trailing_buy", "buy_strategy", "buy_value", "sell_value", "trailing_profit"};
        String max_cost_percentage = "1";
        String buy_strategy = "EMASPREAD";
        String buy_value = runResult.getBuyValue().setScale(1).toString();
        String trailing_buy = runResult.getTrailingBuy().setScale(1).toString();
        String sell_value = runResult.getSellValue().setScale(1).toString();
        String trailing_profit = runResult.getTrailingProfit().setScale(1).toString();
        String pairs = runResult.getSymbol();
          String filePath = "D:/PAIRS.properties";

        File dir = new File(filePath);
        boolean findPairs = false;

        List<String> list = FileUtils.readToList(filePath);
        List<String> listNew = new ArrayList<String>();
        for (String lineStr : list) {
            //System.out.println(s.indexOf("liquan"));
            if (lineStr.indexOf("#") >= 0) {
                listNew.add(lineStr);
                continue;
            }
            if (StringUtils.isEmpty(lineStr)) {
                listNew.add(lineStr);
                continue;
            }
            if (lineStr.indexOf(pairs) >= 0) {
                for (String changeParam : changeParams) {
                    if (lineStr.indexOf(changeParam) >= 0) {
                        findPairs = true;
                        if (changeParam.equals("max_cost_percentage")) {
                            listNew.add(pairs + "_" + "max_cost_percentage = " + max_cost_percentage);
                        }
                        if (changeParam.equals("trailing_buy")) {
                            listNew.add(pairs + "_" + "trailing_buy = " + trailing_buy);
                        }
                        if (changeParam.equals("buy_strategy")) {
                            listNew.add(pairs + "_" + "buy_strategy = " + buy_strategy);
                        }
                        if (changeParam.equals("buy_value")) {
                            listNew.add(pairs + "_" + "buy_value = " + buy_value);
                        }
                        if (buy_strategy.equals("EMACROSS")) {
                            listNew.add(pairs + "_" + "buy_value_limit = " + buy_value);
                        }
                        if (changeParam.equals("sell_value")) {
                            listNew.add(pairs + "_" + "sell_value = " + sell_value);
                        }
                        if (changeParam.equals("trailing_profit")) {
                            listNew.add(pairs + "_" + "trailing_profit = " + trailing_profit);
                        }
                    }
                }
                if(!findPairs){
                    listNew.add(lineStr);
                }
            }else{
                listNew.add(lineStr);
            }
        }
        if (!findPairs) {
            listNew.add(pairs + "_" + "trading_enabled = true" );
            listNew.add(pairs + "_" + "max_cost_percentage = " + max_cost_percentage);
            listNew.add(pairs + "_" + "buy_strategy = " + buy_strategy);
            listNew.add(pairs + "_" + "trailing_buy = " + trailing_buy);
            listNew.add(pairs + "_" + "buy_value = " + buy_value);
            listNew.add(pairs + "_" + "sell_value = " + sell_value);
            listNew.add(pairs + "_" + "trailing_profit = " + trailing_profit);
            listNew.add("                                           ");
        }
        FileUtils.writeLine(filePath, listNew);
    }
	
}
