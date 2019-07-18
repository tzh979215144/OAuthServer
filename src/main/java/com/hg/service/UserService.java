package com.hg.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hg.domain.User;



public interface UserService {

	User selectByUname(String uname);
	String update(Integer uid,String uname,String upassword,String code);
	int updateCode(User record);
	String addString();
	int insert(User record);
}
