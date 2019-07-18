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
public class CodeServiceImpl implements  CodeService {

	@Autowired
//	private UserMapper userMapper;
	private CodeMapper codeMapper;


//	Code selectByCode(String code);
//	void insertByCode(String code, int number);
//	void updateByNumber(String code,int number);
//	void deleteByNumber(int number);
	
	public int selectByCode(String code) {
		// TODO Auto-generated method stub
		return codeMapper.selectByCode(code);
		
	}

	public void insertByCode(String code, int number) {
		codeMapper.insertByCode(code, number);
	}
	
	public void updateByNumber(String code,int number) {
		
		codeMapper.updateByNumber(code, number);
	}
	public void deleteByNumber(int number) {
		codeMapper.deleteByNumber(number);
	}

	
}
