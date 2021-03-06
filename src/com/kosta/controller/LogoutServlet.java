package com.kosta.controller;

import com.kosta.model.EmpVO;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/login/logout.kosta")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext app = getServletContext();
		List<EmpVO> user_list = (List<EmpVO>)app.getAttribute("user_list");
		if(user_list==null) {
			EmpVO emp = (EmpVO) session.getAttribute("emp");
			user_list.remove(emp);
		}
		app.setAttribute("user_list", user_list);
		session.invalidate();

		response.sendRedirect("loginChk.kosta");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
