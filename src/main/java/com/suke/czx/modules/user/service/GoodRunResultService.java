package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.GoodRunResultEntity;

import java.util.List;
import java.util.Map;

/**
 * @author czx
 * @email object_czx@163.com
 * @date 2018-02-04 09:11:43
 */
public interface GoodRunResultService {

    GoodRunResultEntity queryObject(Integer id);

    List<GoodRunResultEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(GoodRunResultEntity goodRunResult);

    void update(GoodRunResultEntity goodRunResult);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

    void udpateByRunResult(int id,String fileType);
}
