package com.hoperun.controller;

import java.net.URISyntaxException;

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
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoperun.dao.TokenMapper;
import com.hoperun.dao.UserMapper;
import com.hoperun.domain.Code;
import com.hoperun.service.CodeService;
import com.hoperun.service.TokenService;
import com.hoperun.service.UserService;

import org.springframework.http.HttpStatus;

@Controller
public class AccessTokenController {
	
	
	@Autowired
	UserService userervice;
	@Autowired
	CodeService codeservice;
	@Autowired
	TokenService tokenservice;
	
	//获取客户端的code码，向客户端返回access token
	@RequestMapping(value="/responseAccessToken",method = RequestMethod.POST)  
	public HttpEntity token(HttpServletRequest request){
		System.out.println("--------服务端/responseAccessToken-----------------------------------------------------------");
		OAuthIssuer oauthIssuerImpl=null;
		 OAuthResponse response=null;
		 boolean flag = false;
		//构建OAuth请求  
	      try {
			OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);
			String authCode = oauthRequest.getParam(OAuth.OAUTH_CODE);
			System.out.println("authCode:"+authCode);
			String clientCode = oauthRequest.getCode();
			System.out.println("clientCode:"+clientCode);
			String clientId = oauthRequest.getClientId();
			System.out.println("clentId:"+clientId);
			String clientSecret = oauthRequest.getClientSecret();
			System.out.println("clientSecret:"+clientSecret);
			
			/**
			 * 判断CODE码是否第一次请求
			 * 判断客户端SECret是否正确
			 */
			int number = codeservice.selectNumberByCode(authCode);//selectNumberByCode
			String pass = "";
					pass = userervice.selectUpasswordByCode(authCode);
			if(number!=0||pass!=clientSecret) {
				flag = true;
			}
			
			System.out.println("setLocationUri:"+oauthRequest.getRedirectURI());
			
			
			if(clientSecret!=null||clientSecret!=""){
				//生成Access Token
	            oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
	            String accessToken = oauthIssuerImpl.accessToken();
	            System.out.println(accessToken);
	            System.out.println("--oooo---");
	          //生成OAuth响应00
	            if(flag) {
	            	//如果不是正常的，则将token设置为error，下一层判断token是否为error
	            	//如果是error，则将与之关联的CODE删除
	            	if(number!=0) {
	            		accessToken="errorByNumber";
	            	}
	            	if(!pass.equals(clientSecret)) {
	            		accessToken="errorBySecret";
	            	}
	            }
	            else {
	            	//如果是正常的请求则，则正常插入访问令牌到数据库
	            	tokenservice.insertByTokenAndCode(accessToken, authCode);
	            }
	            response = OAuthASResponse
	                    .tokenResponse(HttpServletResponse.SC_OK)
	                    .setAccessToken(accessToken)
	                    .buildJSONMessage();
			}	
//			System.out.println("setLocationUri2:"+response.getLocationUri());
//			response.setLocationUri("http://localhost:8080/oauthserver/handleError/reuseCode");
//			System.out.println("setLocationUri3:"+response.getLocationUri());
			System.out.println("--------服务端/responseAccessToken-----------------------------------------------------------");
            
          //根据OAuthResponse生成ResponseEntity
            return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
		} catch (OAuthSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println("--------服务端/responseAccessToken-----------------------------------------------------------");
		return null;
		
		
	}

}
