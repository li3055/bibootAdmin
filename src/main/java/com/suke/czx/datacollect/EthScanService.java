package com.suke.czx.datacollect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suke.czx.common.utils.CHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class EthScanService {

    public String getSymbolTotalBalance(String symbol) {
        String contractAddress = EthScanConstant.symbolContractAddr.get(symbol);
        String url = "https://api.etherscan.io/api?module=stats&action=tokensupply&contractaddress=" + contractAddress + "&apikey=" + EthScanConstant.APIKEY;
        String json = CHttpRequest.sendPost(url, "").toString();
        JSONObject jsonObject = JSON.parseObject(json);
        String result1 = jsonObject.get("result").toString();
        String totalApplyCount = result1.substring(0,result1.length()-18);
        System.out.println(totalApplyCount);
        return totalApplyCount.toString();
    }

}