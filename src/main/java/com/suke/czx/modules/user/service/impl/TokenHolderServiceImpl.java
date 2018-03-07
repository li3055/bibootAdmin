package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.TokenHolderDao;
import com.suke.czx.modules.user.entity.TokenHolderEntity;
import com.suke.czx.modules.user.service.TokenHolderService;



@Service("tokenHolderService")
public class TokenHolderServiceImpl implements TokenHolderService {
	@Autowired
	private TokenHolderDao tokenHolderDao;
	
	@Override
	public TokenHolderEntity queryObject(Integer id){
		return tokenHolderDao.queryObject(id);
	}
	
	@Override
	public List<TokenHolderEntity> queryList(Map<String, Object> map){
		return tokenHolderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tokenHolderDao.queryTotal(map);
	}
	
	@Override
	public void save(TokenHolderEntity tokenHolder){
		tokenHolderDao.save(tokenHolder);
	}
	
	@Override
	public void update(TokenHolderEntity tokenHolder){
		tokenHolderDao.update(tokenHolder);
	}
	
	@Override
	public void delete(Integer id){
		tokenHolderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		tokenHolderDao.deleteBatch(ids);
	}
	
}
