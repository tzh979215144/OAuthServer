package com.hoperun.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hoperun.dao.CodeMapper;
import com.hoperun.dao.TokenMapper;
import com.hoperun.dao.UserMapper;
import com.hoperun.service.AccessTokenService;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {

	@Autowired
	private TokenMapper tokenMapper;
	@Autowired
	private CodeMapper codeMapper;
	@Autowired
	private UserMapper userMapper;

	public Object token(HttpServletRequest request) {
		System.out
				.println("--------服务端/responseAccessToken-----------------------------------------------------------");
		OAuthIssuer oauthIssuerImpl = null;
		OAuthResponse response = null;
		boolean flag = false;
		// 构建OAuth请求
		try {
			OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);
			String authCode = oauthRequest.getParam(OAuth.OAUTH_CODE);
			System.out.println("authCode:" + authCode);
			String clientCode = oauthRequest.getCode();
			System.out.println("clientCode:" + clientCode);
			String clientId = oauthRequest.getClientId();
			System.out.println("clentId:" + clientId);
			String clientSecret = oauthRequest.getClientSecret();
			System.out.println("clientSecret:" + clientSecret);

			/**
			 * 判断CODE码是否第一次请求 判断客户端SECret是否正确
			 */
			int number = codeMapper.selectNumberByCode(authCode);// selectNumberByCode
			System.out.println("number::::" + number);
			String pass = "";
			pass = userMapper.selectUpasswordByCode(authCode);
			if (number != 0 || !pass.equals(clientSecret)) {
				flag = true;
			}

			System.out.println("setLocationUri:" + oauthRequest.getRedirectURI());

			if (clientSecret != null || clientSecret != "") {
				// 生成Access Token
				oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
				String accessToken = oauthIssuerImpl.accessToken();
				System.out.println(accessToken);
				System.out.println("--oooo---");
				// 生成OAuth响应00
				if (flag) {
					// 如果不是正常的，则将token设置为error，下一层判断token是否为error
					// 如果是error，则将与之关联的CODE删除
					if (number != 0) {
						accessToken = "errorByNumber";
					}
					if (!pass.equals(clientSecret)) {
						accessToken = "errorBySecret";
					}
				} else {
					// 如果是正常的请求则，则正常插入访问令牌到数据库
					tokenMapper.insertByTokenAndCode(accessToken, authCode);
				}
				response = OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setAccessToken(accessToken)
						.buildJSONMessage();
			}
			System.out.println(
					"--------服务端/responseAccessToken-----------------------------------------------------------");

			// 根据OAuthResponse生成ResponseEntity
			return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
		} catch (OAuthSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("--------服务端/responseAccessToken-----------------------------------------------------------");
		return null;

	}
}
