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
import com.hoperun.service.UserService;

@Controller
public class ResultInfoController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userInfo") //info消息
	public HttpEntity userInfo(HttpServletRequest request) throws OAuthSystemException{
		System.out.println("-----------服务端/userInfo-------------------------------------------------------------");
	     
		try {
			//获取客户端传来的OAuth资源请求
			OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.QUERY);
			//获取Access Token  
		      String accessToken = oauthRequest.getAccessToken();  
		      System.out.println("accessToken:"+accessToken);
		      String mess="You have succeeded in accessing resource";
		      
		      
		      /**
		       * 如果accessToken是error
		       */
//		      System.out.println("tettetset:"+accessToken.equals("error"));
		      //验证Access Token  
		      if(accessToken.equals("errorByNumber")) {
			        mess="You may be under attack by reuse CODE code.";  
			  }
			  if(accessToken.equals("errorBySecret")) {
				  mess="please check your secret.";
			  }
		      if (accessToken==null||accessToken=="") {  
		        // 如果不存在/过期了，返回未验证错误，需重新验证  
//		      	OAuthResponse oauthResponse = OAuthRSResponse  
//		              .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)  
//		              .setError(OAuthError.ResourceResponse.INVALID_TOKEN)  
//		              .buildHeaderMessage();  
		    	  	System.out.println("error!!!");
//		        HttpHeaders headers = new HttpHeaders();  
//		        headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,   
//		          oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));
	//		      return new ResponseEntity(headers, HttpStatus.UNAUTHORIZED);  
			      }
		      //返回用户名  
//		      User user=userService.selectByUname("");
//		      String username = accessToken+"---"+Math.random()+"----"+user.getUname(); 
//		      System.out.println(username);
//		      System.out.println("服务端/userInfo::::::ppp");
//		      System.out.println("-----------服务端/userInfo----------------------------------------------------------");
		      
		      return new ResponseEntity(mess, HttpStatus.OK);  
		} catch (OAuthProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//检查是否设置了错误码  
		      String errorCode = e.getError();  
		      if (OAuthUtils.isEmpty(errorCode)) {  
		        OAuthResponse oauthResponse = OAuthRSResponse  
		               .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)  
		               .buildHeaderMessage();  
		  
		        HttpHeaders headers = new HttpHeaders();  
		        headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,   
		          oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));  
		        return new ResponseEntity(headers, HttpStatus.UNAUTHORIZED);  
		      }  
		  
		      OAuthResponse oauthResponse = OAuthRSResponse  
		               .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)  
		               .setError(e.getError())  
		               .setErrorDescription(e.getDescription())  
		               .setErrorUri(e.getUri())  
		               .buildHeaderMessage();  
		  
		      HttpHeaders headers = new HttpHeaders();  
		      headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,   
		        oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));  
		      System.out.println("-----------服务端/userInfo------------------------------------------------------------------------------");
		      return new ResponseEntity(HttpStatus.BAD_REQUEST);  
		}  
	      
		
	}

}
