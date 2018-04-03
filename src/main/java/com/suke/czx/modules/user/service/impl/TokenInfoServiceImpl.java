package com.suke.czx.modules.user.service.impl;

import com.suke.czx.datacollect.EthScanService;
import com.suke.czx.modules.user.dao.TokenInfoDao;
import com.suke.czx.modules.user.entity.TokenHolderEntity;
import com.suke.czx.modules.user.entity.TokenInfoEntity;
import com.suke.czx.modules.user.service.TokenHolderService;
import com.suke.czx.modules.user.service.TokenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("tokenInfoService")
public class TokenInfoServiceImpl implements TokenInfoService {
    @Autowired
    private TokenInfoDao tokenInfoDao;
    @Autowired
    private TokenHolderService tokenHolderService;
    @Autowired
    private EthScanService ethScanService;

    @Override
    public TokenInfoEntity queryObject(Integer id) {
        return tokenInfoDao.queryObject(id);
    }

    @Override
    public List<TokenInfoEntity> queryList(Map<String, Object> map) {
        return tokenInfoDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tokenInfoDao.queryTotal(map);
    }

    @Override
    public void save(TokenInfoEntity tokenInfo) {
        tokenInfoDao.save(tokenInfo);
    }

    @Override
    public void update(TokenInfoEntity tokenInfo) {
        tokenInfoDao.update(tokenInfo);
    }

    @Override
    public void delete(Integer id) {
        tokenInfoDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        tokenInfoDao.deleteBatch(ids);
    }

    public void merageTokenHolders(String symbol, int collectDateInt) {
        Map<String, Object> queryMap = new HashMap<>();
        // Integer today = Integer.parseInt(DateUtils.format(new Date(), "yyyyMMdd"));
        queryMap.put("collectDateInt", collectDateInt);
        queryMap.put("symbol", symbol);
        List<TokenInfoEntity> infos = tokenInfoDao.queryList(queryMap);
        if (infos.size() > 0) {
            return;
        }
        //1999420638300000
        //  1999420
        List<TokenHolderEntity> historyList = tokenHolderService.queryList(queryMap);
        //    String totalBalance = ethScanService.getSymbolTotalBalance(symbol);
        //   String totalApplyCount = totalBalance.substring(0, totalBalance.length() - 18);
        double totalApplyCount = 0;
        if (historyList.size() == 300) {
            TokenInfoEntity o = new TokenInfoEntity();
            o.setSymbol(symbol);
            o.setCollectDateInt(collectDateInt);
            double pre50Percent = 0d;
            double pre100Percent = 0d;
            double pre150Percent = 0d;
            double pre200Percent = 0d;
            double pre250Percent = 0d;
            double pre300Percent = 0d;
            for (int i = 0; i < historyList.size(); i++) {
                TokenHolderEntity record = historyList.get(i);
                if (i == 0) {
                    if (record.getPercent() == null || record.getPercent() == 0 || totalApplyCount != 0) {

                    } else {
                        totalApplyCount = record.getBalance() / (record.getPercent() * 0.01);
                    }
                }
                if (i < 50) {
                    pre50Percent += record.getPercent();
                }
                if (i < 100) {
                    pre100Percent += record.getPercent();
                }
                if (i < 150) {
                    pre150Percent += record.getPercent();
                }
                if (i < 200) {
                    pre200Percent += record.getPercent();
                }
                if (i < 250) {
                    pre250Percent += record.getPercent();
                }
                if (i < 300) {
                    pre300Percent += record.getPercent();
                }

            }
            o.setPre50Percent(pre50Percent);
            o.setPre100Percent(pre100Percent);
            o.setPre150Percent(pre150Percent);
            o.setPre200Percent(pre200Percent);
            o.setPre250Percent(pre250Percent);
            o.setPre300Percent(pre300Percent);
            o.setTotalApply(totalApplyCount);
            tokenInfoDao.save(o);
        }
    }

}
