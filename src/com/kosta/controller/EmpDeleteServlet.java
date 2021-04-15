package com.kosta.controller;

import com.kosta.model.EmpDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/emp/empDelete")
public class EmpDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int emp_id = Integer.parseInt(request.getParameter("emp_id"));

        EmpDAO dao = new EmpDAO();

        int result = 0;
        result = dao.deleteEmp(emp_id);

        System.out.println(result + "건 삭제");
        request.setAttribute("message", result + "건 삭제");

        //jsp에게 위임
        RequestDispatcher rd = request.getRequestDispatcher("resultInfo.jsp");
        rd.forward(request, response);
    }
}
