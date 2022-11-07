package com.askSenior.app.member;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.askSenior.app.Result;



public class MemberFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getRequestURI().substring(req.getContextPath().length());
		//Result result = null;
		System.out.print(target);
		Result result = null;
				
		if(target.equals("/member/join.me")) {
			result = new Result();
			result.setPath("/app/member/memberJoin.jsp");
			
		}else if(target.equals("/member/joinOk.me")) {
			result = new JoinOkController().execute(req, resp);
		}else if(target.equals("/member/checkEmail.me")) {
			new CheckEmailController().execute(req, resp);
		}else if(target.equals("/member/login.me")) {
			result = new Result();
			result.setPath("/app/member/memberLogin.jsp");
		}else if(target.equals("/member/loginOk.me")) {
			new LoginOkController().execute(req, resp);
		}else if(target.equals("/member/mypage.me")) {
			
		}else if(target.equals("/member/mypageUpdate.me")) {
			
		}else if(target.equals("/member/logout.me")) {
			
		}
		
		if(result!=null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);;
			}
		}
//		if(result != null) {
//			if(result.isRedirect()) {
//				resp.sendRedirect(result.getPath());
//			}else {
//				req.getRequestDispatcher(result.getPath()).forward(req, resp);
//			}
//			
//		}
		
	}

}





























