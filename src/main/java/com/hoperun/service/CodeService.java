package com.hoperun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoperun.domain.Code;

public interface CodeService {

	int selectNumberByCode(String code);

	void insertByCodeAndNumber(String code, int number);

	void updateByCodeAndNumber(String code, int number);

	void deleteByNumber(int number);
}
