package com.suke.czx.datacollect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suke.czx.common.utils.CHttpRequest;
import com.suke.czx.common.utils.DateUtils;
import com.suke.czx.modules.user.entity.TokenHolderEntity;
import com.suke.czx.modules.user.service.TokenHolderService;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EthScanService {
    public static Map<String, String> symbolBalanceMap = new HashMap<>();

    @Autowired
    private TokenHolderService tokenHolderService;

    public String getSymbolTotalBalance(String symbol) {
        String contractAddress = EthScanConstant.symbolContractAddr.get(symbol);
        String url = "https://api.etherscan.io/api?module=stats&action=tokensupply&contractaddress=" + contractAddress + "&apikey=" + EthScanConstant.APIKEY;
        String json = CHttpRequest.sendPost(url, "").toString();
        JSONObject jsonObject = JSON.parseObject(json);
        String result1 = jsonObject.get("result").toString();
//        String totalApplyCount = result1.substring(0,result1.length()-18);
//        System.out.println(totalApplyCount);
        return result1;
    }


    public void collectData(String symbol, int pageNumber) throws Exception {
        Map<String, Object> queryMap = new HashMap<>();
        Integer today = Integer.parseInt(DateUtils.format(new Date(), "yyyyMMdd"));
        queryMap.put("collectDateInt", today);
        queryMap.put("symbol", symbol);
        List<TokenHolderEntity> historyList = tokenHolderService.queryList(queryMap);
        if(pageNumber ==1 && historyList.size()>=50){
            System.err.println("=================================已经采集，跳过     " + symbol+"  "+pageNumber);
            return;
        }
        if(pageNumber ==2 && historyList.size()>=100){
            System.err.println("=================================已经采集，跳过     " + symbol+"  "+pageNumber);
            return;
        }
        if(pageNumber ==3 && historyList.size()>=150){
            System.err.println("=================================已经采集，跳过     " + symbol+"  "+pageNumber);
            return;
        }
        if(pageNumber ==4 && historyList.size()>=200){
            System.err.println("=================================已经采集，跳过     " + symbol+"  "+pageNumber);
            return;
        }
        if(pageNumber ==5 && historyList.size()>=250){
            System.err.println("=================================已经采集，跳过     " + symbol+"  "+pageNumber);
            return;
        }
        if(pageNumber ==6 && historyList.size()>=300){
            System.err.println("=================================已经采集，跳过     " + symbol+"  "+pageNumber);
            return;
        }

        String contractAddress = EthScanConstant.symbolContractAddr.get(symbol);
        if (!symbolBalanceMap.containsKey(symbol)) {
            String totalBalance = getSymbolTotalBalance(symbol);
            symbolBalanceMap.put(symbol, totalBalance);
        }
        String pageUrl = "https://etherscan.io/token/generic-tokenholders2?a=" + contractAddress + "&s=" + symbolBalanceMap.get(symbol) + "&p=" + pageNumber;

        String crawlStorageFolder = "F:\\testData\\" + pageNumber;


        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxPagesToFetch(2);
        config.setPolitenessDelay(1000);
        config.setCleanupDelaySeconds(1);
        config.setThreadShutdownDelaySeconds(1);
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed(pageUrl);
        controller.start(LocalDataCollectorCrawler.class, 1);

        List<Object> crawlersLocalData = controller.getCrawlersLocalData();

        for (Object localData : crawlersLocalData) {
            CrawlStat stat = (CrawlStat) localData;
            System.out.println(stat.getContent() + "-----------------------------------");
            String[] datas = stat.getContent().split("%");
            for (String data : datas) {
                //System.out.println(data);
                String[] items = data.split(" ");
//                 TokenInfoEntity tokenInfo = new TokenInfoEntity();
////                 tokenInfo.set

                TokenHolderEntity o = new TokenHolderEntity();
                o.setSymbol(symbol);
                o.setCollectDateInt(today);
                int rank = Integer.parseInt(items[1]);
//                if(pageNumber ==2){
//                    rank = rank+50;
//                }else if(pageNumber == 3){
//                    rank = rank+100;
//                }else if(pageNumber ==4){
//                    rank = rank+150;
//                }
                o.setRank(rank);
                o.setAddress(items[2]);
                o.setBalance(Double.parseDouble(items[3]));
                o.setPercent(Double.parseDouble(items[4]));
                tokenHolderService.save(o);
            }
        }

    }

}