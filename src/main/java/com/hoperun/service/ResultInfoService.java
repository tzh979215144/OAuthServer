package com.hoperun.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.http.HttpEntity;

public interface ResultInfoService {
	HttpEntity resultInfo(HttpServletRequest request) throws OAuthSystemException;
}
