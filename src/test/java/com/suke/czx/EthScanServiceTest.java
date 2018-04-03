package com.suke.czx;


import com.suke.czx.common.utils.DateUtils;
import com.suke.czx.datacollect.EthScanConstant;
import com.suke.czx.datacollect.EthScanService;
import com.suke.czx.modules.user.service.HelloConsumer;
import com.suke.czx.modules.user.service.TokenInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EthScanServiceTest {
    @Autowired
    private EthScanService ethScanService;
    @Autowired
    private TokenInfoService tokenInfoService;
    @Autowired
    private HelloConsumer helloConsumer;

    @Test
    public void test() {
        ethScanService.getSymbolTotalBalance("BNB");
    }

    @Test
    public void ttttt() throws Exception {
        helloConsumer.aaaa();
    }

    @Test
    public void collectData2() throws Exception {
        int count = 0;
        for (String symbol : EthScanConstant.symbolContractAddr.keySet()) {
            for (int i = 1; i < 7; i++) {
                count++;
                ethScanService.collectData(symbol, i);
            }
            System.out.println("--------------------------------------------完成collect  " + symbol + " 总数 " + count);
            Thread.sleep(500);
        }
    }

    @Test
    public void merageTokenHolders() throws Exception {

        Integer today = Integer.parseInt(DateUtils.format(new Date(), "yyyyMMdd"));
        for (String symbol : EthScanConstant.symbolContractAddr.keySet()) {
            tokenInfoService.merageTokenHolders(symbol, today);
        }
    }

}
