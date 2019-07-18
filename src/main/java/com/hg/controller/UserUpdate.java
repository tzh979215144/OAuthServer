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

import com.hg.domain.User;
@RequestMapping("/user")
@Controller
public class UserUpdate {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ModelAndView toRegisterUser(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("update");
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String code = request.getParameter("code");
		//更新user表
		userService.update(uid, uname, upassword, code);

		User user = userService.selectByUname("f");
		mv.addObject("user", user);
		return mv;
	}
}
