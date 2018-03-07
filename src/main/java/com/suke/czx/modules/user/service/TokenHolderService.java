package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.TokenHolderEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-03-07 14:19:55
 */
public interface TokenHolderService {
	
	TokenHolderEntity queryObject(Integer id);
	
	List<TokenHolderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TokenHolderEntity tokenHolder);
	
	void update(TokenHolderEntity tokenHolder);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
