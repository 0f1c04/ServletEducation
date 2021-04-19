package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.listener.LoginImpl;
import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login/loginChk.kosta")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int total_user;
    List<EmpVO> user_list = new ArrayList<EmpVO>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("loginForm.html");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost........");

        request.setCharacterEncoding("utf-8");

        int empid = Integer.parseInt(request.getParameter("userid"));
        String email = request.getParameter("userpw");
        EmpDAO dao = new EmpDAO();
        EmpVO emp = dao.loginChk(empid, email);
        request.setAttribute("emp", emp);
        request.setAttribute("username", emp.getFirst_name() + " " +  emp.getLast_name());

        //1.쿠키이용
		/*
		Cookie c1 = new Cookie("empid", empid+"");
		Cookie c2 = new Cookie("email", email);
		Cookie c3 = new Cookie("username", URLEncoder.encode(emp.getFirst_name(), "utf-8") );
		c1.setMaxAge(60*1);
		c2.setMaxAge(60*5);
		c3.setMaxAge(60*60*24);
		String path = getServletContext().getContextPath();
		c1.setPath(path);c2.setPath(path);c3.setPath(path);
		response.addCookie(c1);response.addCookie(c2);response.addCookie(c3);
		*/
        //2.Session이용하기(더 많이 사용된다...)why?보안,사이즈제한없음,브라우져에서쿠키차단과 무관
        //Session은 쿠키기술을 이용 자동으로 sessionID가 쿠키로만들어져서 Browser에 저장된다.
        //정보는 서버 메모리에 저장된다.
        HttpSession session = request.getSession();//있으면얻고 없으면 만든다.
        System.out.println(session.isNew());
        session.setAttribute("empid", empid);
        session.setAttribute("email", email);
        session.setAttribute("emp", emp);
        session.setAttribute("username", emp.getFirst_name()+emp.getLast_name());
        //session.setMaxInactiveInterval(60);  //60초 유지하고자한다.

        LoginImpl login = new LoginImpl(empid, email);
        if(session.isNew()) {
            session.setAttribute("userinfo", login);
            user_list.add(emp);
            ServletContext app = getServletContext();
            app.setAttribute("user_list", user_list);
        }
        String s = "<script>" +
                "setTimeout('history.go(0)',5000);" +
                "</script>";

        request.setAttribute("js", s);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/login/loginResult.jsp");
        rd.forward(request, response);



		/*
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append(String.format("<h1>아이디는 %s</h1>", uid));
		out.append(String.format("<h1>비밀번호는 %s</h1>", upw));
		*/


    }

}
