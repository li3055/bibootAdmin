package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.KkOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-05-13 09:49:11
 */
public interface KkOrderService {
	
	KkOrderEntity queryObject(Integer id);
	
	List<KkOrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(KkOrderEntity kkOrder);
	
	void update(KkOrderEntity kkOrder);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
