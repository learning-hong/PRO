package com.ch.project.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class SessionChk extends HandlerInterceptorAdapter{
	// TRUE OR FALSE로 두가지 경우의 결과만 나타냄?
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("id") == null ||
				session.getAttribute("id").equals("")) {
			response.sendRedirect("");
			return false;
		}	
		return true;
	}
}
