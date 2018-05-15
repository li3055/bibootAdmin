package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.LineDataDao;
import com.suke.czx.modules.user.entity.LineDataEntity;
import com.suke.czx.modules.user.service.LineDataService;



@Service("lineDataService")
public class LineDataServiceImpl implements LineDataService {
	@Autowired
	private LineDataDao lineDataDao;
	
	@Override
	public LineDataEntity queryObject(Integer id){
		return lineDataDao.queryObject(id);
	}
	
	@Override
	public List<LineDataEntity> queryList(Map<String, Object> map){
		return lineDataDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return lineDataDao.queryTotal(map);
	}
	
	@Override
	public void save(LineDataEntity lineData){
		lineDataDao.save(lineData);
	}
	
	@Override
	public void update(LineDataEntity lineData){
		lineDataDao.update(lineData);
	}
	
	@Override
	public void delete(Integer id){
		lineDataDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		lineDataDao.deleteBatch(ids);
	}
	
}
