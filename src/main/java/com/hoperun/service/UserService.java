package com.hoperun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoperun.domain.User;



public interface UserService {

	User selectUserByUname(String uname);
	String update(Integer uid,String uname,String upassword,String code);
	int updateCodeByUser(User record);
	String addString();
	int insertByUser(User record);
	String selectUpasswordByCode(String code);
}
