package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.RunResultEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-02-05 16:01:38
 */
public interface RunResultService {
	
	RunResultEntity queryObject(Integer id);
	
	List<RunResultEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RunResultEntity runResult);
	
	void update(RunResultEntity runResult);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
