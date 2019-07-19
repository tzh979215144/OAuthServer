package com.hg.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hg.domain.*;
import com.hg.service.*;
import com.hg.utils.CreateRandom;





/**
 * 
 * @ClassName: LoginController   
 * @Description: 登录controller
 * @Description:跳转到登录界面
 */

@Controller
public class AuthorizeController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private CodeService codeService;
	
	//向客户端返回授权许可码 code
	@RequestMapping("/responseCode")
	public Object toShowUser(Model model,  HttpServletRequest request){
		System.out.println("----------服务端/responseCode--------------------------------------------------------------");
		
		
	      try {
	    	//构建OAuth 授权请求  
	          OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request); 
	          String uname = oauthRequest.getClientId();
	          oauthRequest.getResponseType();
	          oauthRequest.getRedirectURI();
	          System.out.println("客户ID："+oauthRequest.getClientId());
	          System.out.println("客户secret:"+oauthRequest.getClientSecret());
//	          code
	          System.out.println(oauthRequest.getResponseType());
//	          http://localhost:8080/oauthclient01/server/callbackCode
	          System.out.println(oauthRequest.getRedirectURI());
	          
	      if(oauthRequest.getClientId()!=null&&oauthRequest.getClientId()!="")
	        {
	          /**
	           * 验证ID
	           * 【待做】
	           */
	    	  User u = userService.selectByUname(uname);
	    	  if(u==null)
	    		  return "redirect:"+"http://10.50.130.239:8080/oauthserver/handleError/noClientId";
	    	  
	    	  /**
	    	   * 查看当前合法ID是否已经申请过授权码
	    	   * 如果是，则删除授权码（MySQL外键关联的token表会自动删除对应的字段）
	    	   * 设置当前
	    	   */
	    	  
	        	/**
	        	 * 设置授权码
	        	 * 这里考虑随机生成 
	        	 * 插入CODE表和user表
	        	 */
		          String authorizationCode = CreateRandom.getRandomString(30);
		          codeService.insertByCode(authorizationCode, 0);
		          u.setCode(authorizationCode);
		          userService.updateCode(u);
//		          System.out.println("错误解决！！");
		          
		        //利用oauth授权请求设置responseType，目前仅支持CODE，另外还有TOKEN  
		          String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
		        //进行OAuth响应构建
		          OAuthASResponse.OAuthAuthorizationResponseBuilder builder =
		                    OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND);
		        //设置授权码
		          builder.setCode(authorizationCode);
		        //得到到客户端重定向地址
		          String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);
		        //构建响应
		          final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
		          System.out.println("服务端/responseCode内，返回的回调路径："+response.getLocationUri());
		          System.out.println("----------服务端/responseCode--------------------------------------------------------------");
		         String responceUri =response.getLocationUri();
		         
		        //根据OAuthResponse返回ResponseEntity响应
		            HttpHeaders headers = new HttpHeaders();
		            try {
						headers.setLocation(new URI(response.getLocationUri()));
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            return "redirect:"+responceUri;
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