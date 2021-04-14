package com.kosta.controller;

import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;

import javax.servlet.RequestDispatcher;
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
        List<EmpVO> elist = dao.selectAll();
        request.setAttribute("empall", elist);

        // Servlet이 받은 요청을 jsp에 넘기기: dispatcher(위임)
        RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
        rd.forward(request, response);
    }
}
