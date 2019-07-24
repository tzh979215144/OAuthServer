package com.hoperun.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AuthorizeService {

	Object authorizeService(Model model, HttpServletRequest request);
}
