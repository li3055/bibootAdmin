package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.TokenInfoDao;
import com.suke.czx.modules.user.entity.TokenInfoEntity;
import com.suke.czx.modules.user.service.TokenInfoService;



@Service("tokenInfoService")
public class TokenInfoServiceImpl implements TokenInfoService {
	@Autowired
	private TokenInfoDao tokenInfoDao;
	
	@Override
	public TokenInfoEntity queryObject(Integer id){
		return tokenInfoDao.queryObject(id);
	}
	
	@Override
	public List<TokenInfoEntity> queryList(Map<String, Object> map){
		return tokenInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tokenInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(TokenInfoEntity tokenInfo){
		tokenInfoDao.save(tokenInfo);
	}
	
	@Override
	public void update(TokenInfoEntity tokenInfo){
		tokenInfoDao.update(tokenInfo);
	}
	
	@Override
	public void delete(Integer id){
		tokenInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		tokenInfoDao.deleteBatch(ids);
	}
	
}
