package com.hoperun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView toShowUser() {

		ModelAndView mv = new ModelAndView("index");

		return mv;
	}

}
