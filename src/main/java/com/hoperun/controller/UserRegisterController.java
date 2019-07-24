package com.hoperun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hoperun.domain.User;
import com.hoperun.service.UserRegisterService;
import com.hoperun.utils.CreateRandom;

/**
 * 
 * @ClassName: LoginController
 * @Description: 登录controller
 * @Description:跳转到登录界面
 */

@RequestMapping("/user")
@Controller
public class UserRegisterController {

	@Autowired
	private UserRegisterService userRegisterService;

	@RequestMapping("/register")
	public ModelAndView toShowUser() {
		ModelAndView mv = new ModelAndView("showRegister");
		// 调用service层，返回注册的用户
		User u = userRegisterService.toShowUser();

		// 将生成的用户ID和密码发给注册的用户

		mv.addObject("Uname", u.getUname());
		mv.addObject("Upassword", u.getUpassword());
		mv.addObject("user", u);
		return mv;
	}

}