package com.suke.czx.modules.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoniu.account.comm.page.PageResult;
import com.xiaoniu.account.domain.QueryBalanceReq;
import com.xiaoniu.account.domain.result.CommonRlt;
import com.xiaoniu.account.domain.result.UserBalanceRlt;
import com.xiaoniu.account.service.IUserAssetSOAService;
import com.xiaoniu.account.utils.SignUtils;
import org.springframework.stereotype.Component;

@Component
public class HelloConsumer {
  @Reference(url = "dubbo://10.17.2.205:20880",version = "1.0",group = "p2p")
  private IUserAssetSOAService userAssetSOAService;
  private static final String charset = "UTF-8";


  public void aaaa(){
    QueryBalanceReq accountReq = new QueryBalanceReq();

    accountReq.setUserId("123213");

    //accountReq.setTransTypes(7);
    accountReq.setPageSize(1);
    accountReq.setCurrentPage(1);
    accountReq.setPartnerId("10028");
    accountReq.setCharset(charset);

    accountReq.setSign(SignUtils.addSign(accountReq, charset, "495256cf3723b9087bca1f83018814a7"));

    CommonRlt<PageResult<UserBalanceRlt>> investRlt = userAssetSOAService.queryBalanceRecord(accountReq);
    System.out.println(investRlt);
  }
  
}