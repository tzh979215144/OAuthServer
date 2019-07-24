package com.hoperun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoperun.dao.*;
import com.hoperun.domain.*;
import com.hoperun.service.*;

/**
 * 
 * @ClassName: BuserServiceImpl
 * @Description: 用户管理
 * @author: WANG
 * @date 2017年4月11日 上午11:09:16
 */
@Service
public class TokenServiceImpI implements TokenService {

	@Autowired
	private TokenMapper tokenMapper;

	public String selectTokenByToken(String token) {
		return tokenMapper.selectTokenByToken(token);

	}

	public void insertByTokenAndCode(String token, String code) {
		tokenMapper.insertByTokenAndCode(token, code);
	}

	public void deleteByCode(String code) {
		tokenMapper.deleteByCode(code);
	}

}
