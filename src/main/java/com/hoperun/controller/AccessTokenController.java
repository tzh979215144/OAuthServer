package com.hoperun.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoperun.service.AccessTokenService;

@Controller
public class AccessTokenController {

	@Autowired
	AccessTokenService accessTokenService;

	/**
	 * 获取客户端的code码，向客户端返回access token
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/responseAccessToken", method = RequestMethod.POST)
	public Object token(HttpServletRequest request) {
		System.out
				.println("--------服务端/responseAccessToken-----------------------------------------------------------");
		return accessTokenService.token(request);
	}

}
