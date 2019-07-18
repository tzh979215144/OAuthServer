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





/**
 * 
 * @ClassName: LoginController   
 * @Description: 登录controller
 * @Description:跳转到登录界面
 */

@RequestMapping("/user")
@Controller
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showUser")
	public ModelAndView toShowUser(){
		User user = userService.selectByUname("");
		String string = userService.addString();
		ModelAndView mv = new ModelAndView("user01");
		mv.addObject("user", user);
		mv.addObject("ok", "ok01");
		mv.addObject("string", string);
		System.out.println(user.getUid());
		System.out.println(user.getUname());
		System.out.println(user.getUpassword());
		System.out.println(user.getCode());
		return mv;
	}
	
	
	
}