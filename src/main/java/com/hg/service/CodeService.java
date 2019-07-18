package com.hg.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hg.domain.Code;



public interface CodeService {

	int selectByCode(String code);
	void insertByCode(String code, int number);
	void updateByNumber(String code,int number);
	void deleteByNumber(int number);
}
