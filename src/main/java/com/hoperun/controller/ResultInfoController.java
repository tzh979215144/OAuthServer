package com.hoperun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoperun.domain.User;
import com.hoperun.service.ResultInfoService;
import com.hoperun.service.UserService;
import com.hoperun.service.impl.ResultInfoServiceImpl;

@Controller
public class ResultInfoController {

	@Autowired
	private ResultInfoService resultInfoServiceImpl;

	@RequestMapping("/resultInfo") // info消息
	public HttpEntity resultInfo(HttpServletRequest request) throws OAuthSystemException {
		System.out.println("-----------服务端/userInfo-------------------------------------------------------------");
		return resultInfoServiceImpl.resultInfo(request);
	}

}
