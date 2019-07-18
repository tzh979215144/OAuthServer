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


@RequestMapping("/handleError")
@Controller
public class handleError{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/noClientId")
	public ModelAndView noClentId(){
		ModelAndView mv = new ModelAndView("noclientid");
		String mess = "客户端非法用户，请申请权限";
		mv.addObject("errorMess", mess);
		return mv;
	}
	
	
	
}