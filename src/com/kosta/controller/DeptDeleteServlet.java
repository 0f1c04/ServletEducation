package com.kosta.controller;

import com.kosta.model.DeptDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dept/deptDelete")
public class DeptDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptid = Integer.parseInt(request.getParameter("deptid"));

        DeptDAO dao = new DeptDAO();

        int result = 0;
        result = dao.deleteDept(deptid);

        System.out.println(result + "건 삭제");
        request.setAttribute("message", result + "건 삭제");

        //jsp에게 위임
        RequestDispatcher rd = request.getRequestDispatcher("resultInfo.jsp");
        rd.forward(request, response);
    }
}
