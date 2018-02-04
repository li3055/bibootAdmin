package com.suke.czx.modules.user.service.impl;

import com.suke.czx.modules.user.dao.GoodRunResultDao;
import com.suke.czx.modules.user.entity.GoodRunResultEntity;
import com.suke.czx.modules.user.service.GoodRunResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service("goodRunResultService")
public class GoodRunResultServiceImpl implements GoodRunResultService {
	@Autowired
	private GoodRunResultDao goodRunResultDao;
	
	@Override
	public GoodRunResultEntity queryObject(Integer id){
		return goodRunResultDao.queryObject(id);
	}
	
	@Override
	public List<GoodRunResultEntity> queryList(Map<String, Object> map){
		return goodRunResultDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodRunResultDao.queryTotal(map);
	}
	
	@Override
	public void save(GoodRunResultEntity goodRunResult){
		goodRunResultDao.save(goodRunResult);
	}
	
	@Override
	public void update(GoodRunResultEntity goodRunResult){
		goodRunResultDao.update(goodRunResult);
	}
	
	@Override
	public void delete(Integer id){
		goodRunResultDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		goodRunResultDao.deleteBatch(ids);
	}
	
}
