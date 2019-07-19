package com.hg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hg.dao.UserMapper;
import com.hg.domain.User;
import com.hg.service.UserService;

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


	public User selectByUname(String uname) {
		// TODO Auto-generated method stub
		return userMapper.selectByUname(uname);
		
	}


	public String update(Integer uid,String uname,String upassword,String code) {
		User u=new User();
		u.setUid(uid);
		u.setUname(uname);
		u.setUpassword(upassword);
		u.setCode(code);;
		userMapper.updateByPrimaryKey(u);
		return "OK";
	}
	
	public String addString() {
		// TODO Auto-generated method stub
		return "userServiceAddString";
	}
	
	public int insert(User record) {
		return userMapper.insert(record);
	}
	
	public int updateCode(User record) {
		return userMapper.updateCode(record);
	}
	
	public String selectByCode(String code) {
		// TODO Auto-generated method stub
		return userMapper.selectByCode(code);
	}

	
}
