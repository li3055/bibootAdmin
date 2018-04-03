package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.TokenInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @author czx
 * @email object_czx@163.com
 * @date 2018-03-07 14:19:55
 */
public interface TokenInfoService {

    void merageTokenHolders(String symbol, int collectDateInt);

    TokenInfoEntity queryObject(Integer id);

    List<TokenInfoEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TokenInfoEntity tokenInfo);

    void update(TokenInfoEntity tokenInfo);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

}
