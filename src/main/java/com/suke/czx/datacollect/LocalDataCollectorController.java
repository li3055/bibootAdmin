package com.suke.czx.datacollect;

import com.suke.czx.modules.user.entity.TokenHolderEntity;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LocalDataCollectorController {
    private static final Logger logger =
            LoggerFactory.getLogger(LocalDataCollectorController.class);

    public static void main(String[] args) throws Exception {


        String crawlStorageFolder = "F:\\testData";


        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxPagesToFetch(10);
        config.setPolitenessDelay(1000);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed("https://etherscan.io/token/generic-tokenholders2?a=0xB8c77482e45F1F44dE1745F52C74426C631bDD52&s=197192382000000000000000000&p=1");
        controller.start(LocalDataCollectorCrawler.class, 1);

        List<Object> crawlersLocalData = controller.getCrawlersLocalData();

        for (Object localData : crawlersLocalData) {
            CrawlStat stat = (CrawlStat) localData;
            System.out.println(stat.getContent() + "-----------------------------------");
            String[] datas = stat.getContent().split("%");
            for (String data : datas) {
                System.out.println(data);
                String[] items = data.split(" ");
//                 TokenInfoEntity tokenInfo = new TokenInfoEntity();
////                 tokenInfo.setCollectDateInt(Integer.parseInt(DateUtils.format(new Date(),"yyyyMMdd")));
////                 tokenInfo.set

                TokenHolderEntity o = new TokenHolderEntity();
                o.setRank(Integer.parseInt(items[1]));
                o.setAddress(items[2]);
                o.setBalance(Double.parseDouble(items[3]));
                o.setPercent(Double.parseDouble(items[4]));
                System.out.println(o);
        }
    }
}
}