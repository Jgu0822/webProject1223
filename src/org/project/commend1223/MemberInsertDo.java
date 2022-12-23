package org.project.commend1223;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao1223.MemberDao;

public class MemberInsertDo implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원가입");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		String gender=request.getParameter("gender");
		
		String[] hobbysArr=request.getParameterValues("hobbys");
		String hobbys="";
		for(String hobby:hobbysArr) {
			hobbys+=hobby+" ";
		}
		
		String city=request.getParameter("city");
		String memo=request.getParameter("memo");
		
		//dao
		MemberDao dao = MemberDao.getInstance();
		int result = dao.MemberInsertDo(userId,userPw,gender,hobbys,city,memo);
		
		String forwardURL="";
		
		if (result!=1) {
			System.out.println("회원가입 실패");
			forwardURL="/index.jsp";
		}else {
			System.out.println("회원가입 성공");
			forwardURL="/login.jsp";
		}
		
//		request.setAttribute("result", result);
		request.setAttribute("forwardURL", forwardURL); //request객체
		
		
		
		
	}
}
