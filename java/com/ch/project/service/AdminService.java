package com.ch.project.service;
import javax.servlet.http.HttpSession;
public interface AdminService {
	boolean loginCheck(HttpSession session)throws Exception;    //관리자 로그인을 체크하는 메소드
	
}
