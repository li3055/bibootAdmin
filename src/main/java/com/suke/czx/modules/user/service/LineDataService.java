package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.LineDataEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-05-13 09:51:55
 */
public interface LineDataService {
	
	LineDataEntity queryObject(Integer id);
	
	List<LineDataEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(LineDataEntity lineData);
	
	void update(LineDataEntity lineData);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
