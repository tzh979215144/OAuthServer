package com.hg.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hg.domain.User;
import com.hg.service.UserService;
import com.hg.utils.*;





/**
 * 
 * @ClassName: LoginController   
 * @Description: 登录controller
 * @Description:跳转到登录界面
 */

@RequestMapping("/user")
@Controller
public class UserRegister{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public ModelAndView toShowUser(){
		ModelAndView mv = new ModelAndView("showRegister");
		
		/**
		 * 生成随机的用户id和密码
		 */
		String uname = CreateRandom.getRandomString(15);
		System.out.println("uname"+uname);
		String upassword = CreateRandom.getRandomString(15);
		System.out.println("upassword"+upassword);

		/**
		 * 将生成的用户ID和密码存入数据库
		 */
		User u = new User();
		u.setUname(uname);
		u.setUpassword(upassword);
		int result = userService.insert(u);
		System.out.println(result);
		
		/**
		 * 将生成的用户ID和密码发给注册的用户
		 */
		mv.addObject("uname", uname);
		mv.addObject("upassword", upassword);
		mv.addObject("user", u);
		return mv;
	}
	
	
}