package com.hg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hg.dao.*;
import com.hg.domain.*;
import com.hg.service.*;

/**
 * 
 * @ClassName: BuserServiceImpl   
 * @Description: 用户管理
 * @author: WANG
 * @date 2017年4月11日 上午11:09:16
 */
@Service
public class TokenServiceImpI implements  TokenService {

	@Autowired
//	private UserMapper userMapper;
	private TokenMapper tokenMapper;


//	Token selectByToken(String token);
//	void insertByToken(String Token, String code);
//	void deleteByCode(String code);
	
	public Token selectByToken(String token) {
		// TODO Auto-generated method stub
		return tokenMapper.selectByToken(token);
		
	}

	public void insertByToken(String token, String code) {
		tokenMapper.insertByToken(token, code);
	}
	
	public void deleteByCode(String code) {
		tokenMapper.deleteByCode(code);
	}
	

	
}
