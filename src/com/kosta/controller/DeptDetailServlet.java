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
import java.sql.SQLException;

@WebServlet("/dept/deptDetail")
public class DeptDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //수정하기
        request.setCharacterEncoding("utf-8");
        //int did = convertInt(request.getParameter("dept_id")); //department_id
        int did = Integer.parseInt(request.getParameter("dept_id")); //department_id
        String dname = request.getParameter("dept_name"); //department_name
        int mid = convertInt(request.getParameter("manager_id"));
        int locid = convertInt(request.getParameter("location_id"));

        DeptVO dept = new DeptVO(did, dname, mid, locid);
        DeptDAO dao = new DeptDAO();

        int result = 0;
        result = dao.updateDept(dept);

        System.out.println(result + "건 수정");
        request.setAttribute("message", result + "건 수정");

        //jsp에게 위임
        RequestDispatcher rd = request.getRequestDispatcher("resultInfo.jsp");
        rd.forward(request, response);
    }

    private int convertInt(String param) { //String -> int
        if(param == null) return 0;
        return Integer.parseInt(param);
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
