package com.kosta.controller;

import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/emp/emplist")
public class EmpListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDAO dao = new EmpDAO();
        request.setAttribute("empall", dao.selectAll());

        /*
        servlet이 요청을 받아서 JSP에 위임(forward)
         */
        request.setAttribute("myname", "deokbae");
        request.setAttribute("myscore", 100);
        EmpVO emp = new EmpVO();
        emp.setFirst_name("직원이름:임덕배");
        emp.setSalary(2000);
        request.setAttribute("myemp", emp);

        //servlet context: application 당 하나
        ServletContext app = getServletContext();
        app.setAttribute("appInfo", "환영합니다");

        System.out.println("info:" + request.getAttribute("info"));

        System.out.println("dbName:" + app.getInitParameter("dbname"));
        System.out.println("userid:" + app.getInitParameter("userid"));

        // Servlet이 받은 요청을 jsp에 넘기기: dispatcher(위임)
        RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
        rd.forward(request, response);
    }
}
