package com.hoperun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoperun.dao.UserMapper;
import com.hoperun.domain.User;
import com.hoperun.service.UserService;

/**
 * 
 * @ClassName: BuserServiceImpl   
 * @Description: 用户管理
 * @author: WANG
 * @date 2017年4月11日 上午11:09:16
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;


	public User selectUserByUname(String uname) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByUname(uname);
		
	}


	public String update(Integer uid,String uname,String upassword,String code) {
		User u=new User();
		u.setUid(uid);
		u.setUname(uname);
		u.setUpassword(upassword);
		u.setCode(code);;
		userMapper.updateByUser(u);
		return "OK";
	}
	
	public String addString() {
		// TODO Auto-generated method stub
		return "userServiceAddString";
	}
	
	public int insertByUser(User record) {
		return userMapper.insertByUser(record);
	}
	
	public int updateCodeByUser(User record) {
		return userMapper.updateCodeByUser(record);
	}
	
	public String selectUpasswordByCode(String code) {
		// TODO Auto-generated method stub
		return userMapper.selectUpasswordByCode(code);
	}

	
}
