package com.hoperun.service.impl;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hoperun.dao.CodeMapper;
import com.hoperun.dao.UserMapper;
import com.hoperun.domain.User;
import com.hoperun.service.AuthorizeService;
import com.hoperun.utils.CreateRandom;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {

	@Autowired
	private CodeMapper codeMapper;
	@Autowired
	private UserMapper userMapper;

	public Object authorizeService(Model model, HttpServletRequest request) {
		System.out.println("----------服务端/responseCode--------------------------------------------------------------");

		try {
			// 构建OAuth 授权请求
			OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
			String uname = oauthRequest.getClientId();
			oauthRequest.getResponseType();
			oauthRequest.getRedirectURI();
			System.out.println("客户ID：" + oauthRequest.getClientId());
//	          code
			System.out.println(oauthRequest.getResponseType());
//	          http://localhost:8080/oauthclient01/server/callbackCode
			System.out.println(oauthRequest.getRedirectURI());

			if (oauthRequest.getClientId() != null && oauthRequest.getClientId() != "") {
				/**
				 * 验证ID 【待做】
				 */
				User u = userMapper.selectUserByUname(uname);
				if (u == null)
					return "redirect:" + "http://10.50.130.239:8080/oauthserver/handleError/noClientId";

				/**
				 * 查看当前合法ID是否已经申请过授权码 如果是，则不再更新授权码 目的：防止有人恶意申请CODE码，导致正常用户的CODE码被更新
				 */
				String authorizationCode = u.getCode();
//	    	  System.out.println("herfdsfdf::"+authorizationCode);
				if (authorizationCode.equals("")) {
					/**
					 * 设置授权码 这里考虑随机生成 插入CODE表和user表
					 */
					System.out.println("herer::" + authorizationCode);
					authorizationCode = CreateRandom.getRandomString(30);
					codeMapper.insertByCodeAndNumber(authorizationCode, 0);
					u.setCode(authorizationCode);
					userMapper.updateCodeByUser(u);
				}
				// 利用oauth授权请求设置responseType，目前仅支持CODE，另外还有TOKEN
				String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
				// 进行OAuth响应构建
				OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse
						.authorizationResponse(request, HttpServletResponse.SC_FOUND);

				// 设置授权码
				builder.setCode(authorizationCode);
				// 得到到客户端重定向地址
				String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);
				// 构建响应
				final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
				System.out.println("服务端/responseCode内，返回的回调路径：" + response.getLocationUri());
				System.out.println(
						"----------服务端/responseCode--------------------------------------------------------------");
				String responceUri = response.getLocationUri();

				// 根据OAuthResponse返回ResponseEntity响应
				HttpHeaders headers = new HttpHeaders();
				try {
					headers.setLocation(new URI(response.getLocationUri()));
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "redirect:" + responceUri;
			}

		} catch (OAuthSystemException e) {
			e.printStackTrace();
		} catch (OAuthProblemException e) {
			e.printStackTrace();
		}
		System.out.println("----------服务端/responseCode--------------------------------------------------------------");
		return null;

	}
}
