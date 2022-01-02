package com.ch.project.service;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import com.ch.project.dao.AdminDao;
public abstract class AdminServiceImpl implements AdminService {
	@Inject    //dao를 호출하기때문에 의존성을 주입한다.
    AdminDao adminDao;
    @Override    //로그인 체크 관련 메소드 (세션에 아이디와 비밀번호를 저장함)
    public abstract boolean loginCheck(HttpSession session) throws Exception;
}
 
