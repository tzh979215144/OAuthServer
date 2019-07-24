package com.hoperun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoperun.service.*;

/**
 * 
 * @ClassName: LoginController
 * @Description: 登录controller
 * @Description:跳转到登录界面
 */

@Controller
public class AuthorizeController {

	@Autowired
	private AuthorizeService authorizeService;

	/**
	 * 向客户端返回授权许可码 code
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/responseCode")
	public Object toShowUser(Model model, HttpServletRequest request) {
		System.out.println("----------服务端/responseCode--------------------------------------------------------------");
		return authorizeService.authorizeService(model, request);
	}

}