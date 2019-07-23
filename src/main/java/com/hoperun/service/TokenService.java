package com.hoperun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoperun.domain.Token;



public interface TokenService {

	String selectTokenByToken(String token);
	void insertByTokenAndCode(String token, String code);
	void deleteByCode(String code);
}
