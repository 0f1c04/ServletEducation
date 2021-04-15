package com.kosta.controller;

import com.kosta.model.DeptDAO;
import com.kosta.model.DeptVO;
import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;
import com.kosta.util.ConvertUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/emp/empDetail")
public class EmpDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_id = request.getParameter("emp_id");
        int i_empid = Integer.parseInt(emp_id);
        EmpDAO dao = new EmpDAO();
        EmpVO emp = dao.selectById(i_empid);
        request.setAttribute("emp", emp);
        request.setAttribute("joblist", dao.selectAllJobID());
        request.setAttribute("mlist", dao.selectAllManagerID());
        request.setAttribute("dlist", dao.selectAllDepartmentID());

        //request.setAttribute("info");

        // jsp에게 위임
        RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
        rd.forward(request, response);
    }
}
