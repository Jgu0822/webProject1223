package org.project.controller1223;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.commend1223.LoginOkDo;
import org.project.commend1223.LogoutDo;
import org.project.commend1223.MemberCommend;
import org.project.commend1223.MemberDeleteDo;
import org.project.commend1223.MemberInsertDo;
import org.project.commend1223.MemberSelectDo;
import org.project.commend1223.MemberUpdateDo;


@WebServlet("*.do")
public class MemberController extends HttpServlet{
	//get,post -> 메소드 webApp(); 구현

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("GET");
		webApp(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("POST");
		webApp(request, response);
	}
	
	protected void webApp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getContextPath();
		String uri=request.getRequestURI();
		String basicURL=uri.substring(path.length());
		
		String forwardURL="";
		
		MemberCommend commend = null;
		
		if (basicURL.equals("/memberInsert.do")) {
			//일 시키고 -> commend
			commend=new MemberInsertDo();
			commend.excuteQueryCommend(request, response);
			//View -> url,값
			forwardURL=(String) request.getAttribute("forwardURL");
			
		}else if (basicURL.equals("/memberUpdate.do")) {
			commend=new MemberUpdateDo();
			commend.excuteQueryCommend(request, response);
			forwardURL=(String) request.getAttribute("forwardURL");
			
		}else if (basicURL.equals("/memberDelete.do")) {
			commend=new MemberDeleteDo();
			commend.excuteQueryCommend(request, response);
			forwardURL=(String) request.getAttribute("forwardURL");
			
		}else if (basicURL.equals("/memberSelect.do")) {
			commend=new MemberSelectDo();
			commend.excuteQueryCommend(request, response);
			forwardURL=(String) request.getAttribute("forwardURL");
			
		}else if (basicURL.equals("/loginOk.do")) {
			commend=new LoginOkDo();
			commend.excuteQueryCommend(request, response);
			forwardURL=(String) request.getAttribute("forwardURL");
			
		}else if (basicURL.equals("/logoutOk.do")) {
			commend=new LogoutDo();
			commend.excuteQueryCommend(request, response);
			forwardURL=(String) request.getAttribute("forwardURL");
			
		}else if (basicURL.equals("/index.do")) {		//index.jsp
			forwardURL="/index.jsp";
		}else if (basicURL.equals("/joinView.do")) {	//join.jsp
			forwardURL="/join.jsp";
		}else if (basicURL.equals("/loginView.do")) {	//login.jsp
			forwardURL="/login.jsp";
		}
		
		
		//View -> url,값
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}
}
