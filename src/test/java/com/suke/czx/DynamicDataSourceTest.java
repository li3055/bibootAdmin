package com.suke.czx;


import com.suke.czx.common.utils.CHttpRequest;
import com.suke.czx.common.utils.DateUtils;
import com.suke.czx.datasources.DataSourceTestService;
import com.suke.czx.modules.user.entity.UserEntity;
import net.sf.json.JSONObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {
    @Autowired
    private DataSourceTestService dataSourceTestService;

    @Test
    public void test(){
        //数据源1
        UserEntity user = dataSourceTestService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user));

        //数据源2
        UserEntity user2 = dataSourceTestService.queryObject2(1L);
        System.out.println(ToStringBuilder.reflectionToString(user2));

        //数据源1
        UserEntity user3 = dataSourceTestService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user3));
    }
    @Test
    public void test22()throws  Exception{
        Date start = DateUtils.strToDate("2018-01-01 01:00:00");
        Date end = DateUtils.strToDate("2018-02-04 10:30:00" );
        String base = "http://localhost:8800/backtest/single?";
        String params = "startDate="+start.getTime()+"&endDate="+end.getTime()+"&symbol="+"ETHBTC"+"&trailingBuy=1&buyValue=10&sellValue=10&trailingProfit=1";
       Object single = CHttpRequest.sendPost( base+params,"");
//        JSONObject single = CHttpRequest.httpRequest("http://localhost:8800/backtest", "single");
        System.err.println(single);
    }

}
