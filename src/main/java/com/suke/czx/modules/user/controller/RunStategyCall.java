package com.suke.czx.modules.user.controller;

import com.suke.czx.common.utils.CHttpRequest;
import com.suke.czx.modules.user.entity.RunResultEntity;

import java.util.concurrent.Callable;

public class RunStategyCall implements Callable<RunResultEntity> {
    private String url;


    public RunStategyCall(String url) {
        this.url = url;
    }

    @Override
    public RunResultEntity call() throws Exception {

        RunResultEntity da = new RunResultEntity();
        try {
            Object single = CHttpRequest.sendPost(this.url, "");
            da = com.alibaba.fastjson.JSON.parseObject(single.toString(), RunResultEntity.class);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return da;
    }
}