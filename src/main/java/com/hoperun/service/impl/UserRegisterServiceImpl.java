package com.hoperun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.hoperun.domain.User;
import com.hoperun.service.UserRegisterService;
import com.hoperun.service.UserService;
import com.hoperun.utils.CreateRandom;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	@Autowired
	private UserService userService;

	public User toShowUser() {
		/**
		 * 生成随机的用户id和密码
		 */
		String uname = CreateRandom.getRandomString(15);
		System.out.println("uname" + uname);
		String upassword = CreateRandom.getRandomString(15);
		System.out.println("upassword" + upassword);

		/**
		 * 将生成的用户ID和密码存入数据库
		 */
		User u = new User();
		u.setUname(uname);
		u.setUpassword(upassword);
		int result = userService.insertByUser(u);
		System.out.println(result);

		/**
		 * 将生成的用户ID和密码发给注册的用户
		 */

		return u;
	}
}
