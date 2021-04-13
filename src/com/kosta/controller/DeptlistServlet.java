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
import java.util.List;

@WebServlet("/deptlist")
public class DeptlistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptDAO dao = new DeptDAO();
        List<DeptVO> dlist = dao.selectAll();
        request.setAttribute("deptall", dlist);

        // Servlet이 받은 요청을 jsp에 넘기기: dispatcher(위임)
        RequestDispatcher rd = request.getRequestDispatcher("dept_retrieve.jsp");
        rd.forward(request, response);
    }
}
