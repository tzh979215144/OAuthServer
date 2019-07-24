package com.hoperun.service;

import javax.servlet.http.HttpServletRequest;

public interface AccessTokenService {

	Object token(HttpServletRequest request);
}
