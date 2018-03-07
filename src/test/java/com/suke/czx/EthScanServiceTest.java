package com.suke.czx;


import com.suke.czx.datacollect.EthScanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EthScanServiceTest {
    @Autowired
    private EthScanService ethScanService;

    @Test
    public void test(){
        ethScanService.getSymbolTotalBalance("BNB");
    }
    @Test
    public void test22()throws  Exception{

    }

}
