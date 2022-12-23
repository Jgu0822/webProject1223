package org.project.commend1223;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao1223.MemberDao;

public class LoginOkDo implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		MemberDao dao = MemberDao.getInstance();
		
		int result=dao.LoginOkDo(userId, userPw);
		
		String forwardURL=" ";
		
		HttpSession session=request.getSession(); //세션 객체 생성
		
		if (result!=1) {
			System.out.println("로그인 실패");
			forwardURL="/login.jsp";
		}else {
			System.out.println("로그인 성공");
			session.setMaxInactiveInterval(60*30); //세션 시간 설정 30분
			session.setAttribute("sessionId",userId); //세션 아이디 설정
			forwardURL="/loginOk.jsp";
		}
		request.setAttribute("forwardURL", forwardURL);
	}

}