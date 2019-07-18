package com.hg.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hg.domain.Token;



public interface TokenService {

	Token selectByToken(String token);
	void insertByToken(String token, String code);
	void deleteByCode(String code);
}
