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
public class CodeServiceImpl implements CodeService {

	@Autowired
	private CodeMapper codeMapper;

	public int selectNumberByCode(String code) {
		return codeMapper.selectNumberByCode(code);

	}

	public void insertByCodeAndNumber(String code, int number) {
		codeMapper.insertByCodeAndNumber(code, number);
	}

	public void updateByCodeAndNumber(String code, int number) {

		codeMapper.updateByCodeAndNumber(code, number);
	}

	public void deleteByNumber(int number) {
		codeMapper.deleteByNumber(number);
	}

}
