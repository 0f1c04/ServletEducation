package com.kosta.controller;

import com.kosta.model.DeptDAO;
import com.kosta.model.DeptVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deptDetail")
public class DeptDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_deptid = request.getParameter("deptid");
        int i_deptid = Integer.parseInt(s_deptid);
        DeptDAO dao = new DeptDAO();
        DeptVO dept = dao.selectById(i_deptid);
        request.setAttribute("dept", dept);
        request.setAttribute("myname", "임덕배");

        // jsp에게 위임
        RequestDispatcher rd = request.getRequestDispatcher("deptDetail.jsp");
        rd.forward(request, response);
    }
}
