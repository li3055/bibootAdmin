package com.suke.czx.modules.user.controller;

import com.suke.czx.common.contants.BibootAdminConstant;
import com.suke.czx.common.utils.*;
import com.suke.czx.modules.user.entity.GoodRunResultEntity;
import com.suke.czx.modules.user.entity.RunResultEntity;
import com.suke.czx.modules.user.service.GoodRunResultService;
import com.suke.czx.modules.user.service.RunResultService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


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
    @Autowired
    private GoodRunResultService goodRunResultService;

    static Integer runId;

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
        if (query.get("symbol") != null) {
            runResultList = queryByhandle(params);
        } else {

            GoodRunResultEntity goodRunResultEntity = goodRunResultService.queryObject(runId);

            String symbol = goodRunResultEntity.getSymbol();
            if (StringUtils.isEmpty(symbol)) {
                PageUtils pageUtil = new PageUtils(runResultList, total, query.getLimit(), query.getPage());
                return R.ok().put("page", pageUtil);
            }
            String trailingBuy = goodRunResultEntity.getTrailingBuy().toString();
            String buyValue = goodRunResultEntity.getBuyValue().toString();
            String sellValue = goodRunResultEntity.getSellValue().toString();
            String trailingProfit = goodRunResultEntity.getTrailingProfit().toString();
            List<String> urls = makeUrls(symbol, trailingBuy, buyValue, sellValue, trailingProfit);
            runResultList = batchRunFurtherInter(urls,runId);
        }

        PageUtils pageUtil = new PageUtils(runResultList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);

    }

    private List<String> makeUrls(String symbol, String trailingBuy, String buyValue, String sellValue, String trailingProfit) {
        List<String> urls = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            StringBuffer bf = new StringBuffer("http://localhost:8800/backtest/single?");
            Date start = null;
            Date end = null;

            if (i == 0) {

                  start = DateUtils.parseDate("2018-01-01 05:35:00", "yyyy-MM-dd HH:mm:ss");
                  end = DateUtils.parseDate("2018-03-06 09:15:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");

            } else if (i == 1) {

                start = DateUtils.parseDate("2018-01-01 02:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-02-01 10:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");

            } else if (i == 2) {

                start = DateUtils.parseDate("2018-02-01 12:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-03-13 10:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");

            } else if (i == 3) {

                start = DateUtils.parseDate("2018-02-17 12:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-03-13 10:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");

            } else if (i == 4) {

                start = DateUtils.parseDate("2018-02-23 02:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-03-13 10:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");
            } else if (i == 5) {
                start = DateUtils.parseDate("2018-03-01 02:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-03-13 10:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");
            } else {
                start = DateUtils.parseDate("2018-03-07 02:00:00", "yyyy-MM-dd HH:mm:ss");
                end = DateUtils.parseDate("2018-03-13 10:00:00", "yyyy-MM-dd HH:mm:ss");
                bf.append("startDate=").append(start.getTime()).append("&");
                bf.append("endDate=").append(end.getTime()).append("&");
            }


            bf.append("symbol=").append(symbol).append("&");
            bf.append("trailingBuy=").append(trailingBuy).append("&");
            bf.append("buyValue=").append(buyValue).append("&");
            bf.append("sellValue=").append(sellValue).append("&");
            bf.append("trailingProfit=").append(trailingProfit);
            urls.add(bf.toString());
        }
        return urls;
    }

    private List<RunResultEntity> batchRunFurtherInter(List<String> urls,Integer runId) {
        Integer id = runId;
        List<RunResultEntity> runResultList = new ArrayList<>();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        ArrayList<Future<RunResultEntity>> futures = new ArrayList<Future<RunResultEntity>>();//
        for (String url : urls) {
            futures.add(fixedThreadPool.submit(new RunStategyCall(url)));//submit返回一个Future，代表了即将要返回的结果
        }
        // System.out.println("获取结果中...");
        RunResultEntity sum = new RunResultEntity();
        for (Future<RunResultEntity> f : futures) {
            try {
                RunResultEntity da = f.get();
                da.setId(id);
                runResultList.add(da);
                caculateBad(sum, da);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        runResultList.add(sum);


        return runResultList;
    }

    public RunResultEntity caculateBad(RunResultEntity badResult, RunResultEntity r) {
        if (badResult.getRewardRisk() == null) {
            badResult.setTotalProfit(r.getTotalProfit());
            badResult.setRewardRisk(r.getRewardRisk());
            badResult.setMaximumDrawdown(r.getMaximumDrawdown());
            badResult.setTransactionCost(BigDecimal.valueOf(1));
        }
        if (r.getTotalProfit() != null) {


            BigDecimal totalProfit = badResult.getTotalProfit();
            BigDecimal rewardRisk = badResult.getRewardRisk();
            BigDecimal maximumDrawdown = badResult.getMaximumDrawdown();

            BigDecimal badTimes = badResult.getTransactionCost();
            if (badTimes == null) {
                badTimes = BigDecimal.valueOf(1);
            }
            BigDecimal divceCount = badTimes.add(BigDecimal.valueOf(1));
            totalProfit = totalProfit.multiply(badTimes).add(r.getTotalProfit());
            rewardRisk = rewardRisk.multiply(badTimes).add(r.getRewardRisk());
            maximumDrawdown = maximumDrawdown.multiply(badTimes).add(r.getMaximumDrawdown());
            badResult.setTotalProfit(totalProfit.divide(divceCount, 3, BigDecimal.ROUND_HALF_UP));
            badResult.setRewardRisk(rewardRisk.divide(divceCount, 3, BigDecimal.ROUND_HALF_UP));
            badResult.setMaximumDrawdown(maximumDrawdown.divide(divceCount, 3, BigDecimal.ROUND_HALF_UP));
            badResult.setTransactionCost(divceCount);
        }
        return badResult;
    }


    private List<RunResultEntity> queryByhandle(Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RunResultEntity> runResultList = new ArrayList<>();
        String symbol = query.get("symbol").toString();
        if (StringUtils.isEmpty(symbol)) {
            return runResultList;
        }
        String trailingBuy = query.get("trailingBuy").toString();
        String buyValue = query.get("buyValue").toString();
        String sellValue = query.get("sellValue").toString();
        String trailingProfit = query.get("trailingProfit").toString();
        List<String> urls = makeUrls(symbol, trailingBuy, buyValue, sellValue, trailingProfit);
        runResultList = batchRunFurtherInter(urls,runId);
        return runResultList;
    }


    @RequestMapping("/list2/{id}")
    public ModelAndView list2(@PathVariable("id") String id) {
        System.out.println("id= " + id);
        runId = Integer.parseInt(id);
        ModelAndView mv = new ModelAndView("redirect:http://localhost:8080/x_springboot/index.html#modules/user/runresult.html");

        return mv;
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
     * 熊市策略
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:runresult:update")
    public R xiong(@RequestBody Integer[] ids) {
        goodRunResultService.udpateByRunResult(ids[0], BibootAdminConstant.XIONG);

        return R.ok();
    }

    /**
     * 牛市策略
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:runresult:delete")
    public R niu(@RequestBody Integer[] ids) {
        goodRunResultService.udpateByRunResult(ids[0], BibootAdminConstant.NIU);

        return R.ok();
    }

}
