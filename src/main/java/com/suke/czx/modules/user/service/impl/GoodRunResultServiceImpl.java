package com.suke.czx.modules.user.service.impl;

import com.suke.czx.common.contants.BibootAdminConstant;
import com.suke.czx.common.utils.FileUtils;
import com.suke.czx.common.utils.StringUtils;
import com.suke.czx.modules.user.dao.GoodRunResultDao;
import com.suke.czx.modules.user.entity.GoodRunResultEntity;
import com.suke.czx.modules.user.service.GoodRunResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("goodRunResultService")
public class GoodRunResultServiceImpl implements GoodRunResultService {
    @Autowired
    private GoodRunResultDao goodRunResultDao;

    @Override
    public GoodRunResultEntity queryObject(Integer id) {
        return goodRunResultDao.queryObject(id);
    }

    @Override
    public List<GoodRunResultEntity> queryList(Map<String, Object> map) {
        return goodRunResultDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return goodRunResultDao.queryTotal(map);
    }

    @Override
    public void save(GoodRunResultEntity goodRunResult) {
        goodRunResultDao.save(goodRunResult);
    }

    @Override
    public void update(GoodRunResultEntity goodRunResult) {
        goodRunResultDao.update(goodRunResult);
    }

    @Override
    public void delete(Integer id) {
        goodRunResultDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        goodRunResultDao.deleteBatch(ids);
    }

    @Override
    public void udpateByRunResult(int id, String fileType) {
        GoodRunResultEntity runResult = goodRunResultDao.queryObject(id);
        String[] changeParams = {"max_cost_percentage", "trailing_buy", "buy_strategy", "buy_value", "sell_value", "trailing_profit"};
        String max_cost_percentage = "1";
        String buy_strategy = "EMASPREAD";
        String buy_value = runResult.getBuyValue().setScale(1).toString();
        String trailing_buy = runResult.getTrailingBuy().setScale(1).toString();
        String sell_value = runResult.getSellValue().setScale(1).toString();
        String trailing_profit = runResult.getTrailingProfit().setScale(1).toString();
        String pairs = runResult.getSymbol();
        String filePath = "D:/PAIRS.properties";


        if (runResult.getSymbol().indexOf("USDT") != -1) {
            if (fileType.equals(BibootAdminConstant.NIU)) {
                filePath = "D:\\ProfitTrailer - usdt\\trading\\niu_shi.properties";
            } else if (fileType.equals(BibootAdminConstant.XIONG)) {
                filePath = "D:\\ProfitTrailer - usdt\\trading\\xiong_shi.properties";
            } else {
                System.err.println("========================================================指定文件类型==============================");
            }
        } else {
            if (fileType.equals(BibootAdminConstant.NIU)) {
                filePath = "D:/niu_shi.properties";
            } else if (fileType.equals(BibootAdminConstant.XIONG)) {
                filePath = "D:/xiong_shi.properties";
            } else {
                System.err.println("========================================================指定文件类型==============================");
            }
        }

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
                if (!findPairs) {
                    listNew.add(lineStr);
                }
            } else {
                listNew.add(lineStr);
            }
        }
        if (!findPairs) {
            listNew.add(pairs + "_" + "trading_enabled = true");
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
