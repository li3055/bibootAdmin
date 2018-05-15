package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.KkOrderDao;
import com.suke.czx.modules.user.entity.KkOrderEntity;
import com.suke.czx.modules.user.service.KkOrderService;



@Service("kkOrderService")
public class KkOrderServiceImpl implements KkOrderService {
	@Autowired
	private KkOrderDao kkOrderDao;
	
	@Override
	public KkOrderEntity queryObject(Integer id){
		return kkOrderDao.queryObject(id);
	}
	
	@Override
	public List<KkOrderEntity> queryList(Map<String, Object> map){
		return kkOrderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return kkOrderDao.queryTotal(map);
	}
	
	@Override
	public void save(KkOrderEntity kkOrder){
		kkOrderDao.save(kkOrder);
	}
	
	@Override
	public void update(KkOrderEntity kkOrder){
		kkOrderDao.update(kkOrder);
	}
	
	@Override
	public void delete(Integer id){
		kkOrderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		kkOrderDao.deleteBatch(ids);
	}
	
}
