package com.hoperun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/handleError")
@Controller
public class handleError {

	@RequestMapping("/noClientId")
	public ModelAndView noClentId() {
		ModelAndView mv = new ModelAndView("noclientid");
		String mess = "客户端非法用户，请申请权限";
		mv.addObject("errorMess", mess);
		return mv;
	}

}