package com.hoperun.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hoperun.service.ResultInfoService;

@Service
public class ResultInfoServiceImpl implements ResultInfoService {

	public HttpEntity resultInfo(HttpServletRequest request) throws OAuthSystemException {
		System.out.println("-----------服务端/userInfo-------------------------------------------------------------");

		try {
			// 获取客户端传来的OAuth资源请求
			OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.QUERY);
			// 获取Access Token
			String accessToken = oauthRequest.getAccessToken();
			System.out.println("accessToken:" + accessToken);
			String mess = "You have succeeded in accessing resource";

			// 验证Access Token
			if (accessToken.equals("errorByNumber")) {
				mess = "You may be under attack by reuse CODE code.";
			}
			if (accessToken.equals("errorBySecret")) {
				mess = "please check your secret.";
			}
			if (accessToken == null || accessToken == "") {
				mess = "what are you doing??";
				System.out.println("error!!!");
			}
			return new ResponseEntity(mess, HttpStatus.OK);
		} catch (OAuthProblemException e) {
			e.printStackTrace();

			// 检查是否设置了错误码
			String errorCode = e.getError();
			if (OAuthUtils.isEmpty(errorCode)) {
				OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
						.buildHeaderMessage();

				HttpHeaders headers = new HttpHeaders();
				headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,
						oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));
				return new ResponseEntity(headers, HttpStatus.UNAUTHORIZED);
			}

			OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
					.setError(e.getError()).setErrorDescription(e.getDescription()).setErrorUri(e.getUri())
					.buildHeaderMessage();

			HttpHeaders headers = new HttpHeaders();
			headers.add(OAuth.HeaderType.WWW_AUTHENTICATE, oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));
			System.out.println(
					"-----------服务端/userInfo------------------------------------------------------------------------------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
