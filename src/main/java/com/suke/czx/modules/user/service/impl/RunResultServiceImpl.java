package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.RunResultDao;
import com.suke.czx.modules.user.entity.RunResultEntity;
import com.suke.czx.modules.user.service.RunResultService;



@Service("runResultService")
public class RunResultServiceImpl implements RunResultService {
	@Autowired
	private RunResultDao runResultDao;
	
	@Override
	public RunResultEntity queryObject(Integer id){
		return runResultDao.queryObject(id);
	}
	
	@Override
	public List<RunResultEntity> queryList(Map<String, Object> map){
		return runResultDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return runResultDao.queryTotal(map);
	}
	
	@Override
	public void save(RunResultEntity runResult){
		runResultDao.save(runResult);
	}
	
	@Override
	public void update(RunResultEntity runResult){
		runResultDao.update(runResult);
	}
	
	@Override
	public void delete(Integer id){
		runResultDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		runResultDao.deleteBatch(ids);
	}
	
}
