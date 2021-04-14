package com.kosta.controller;

import com.kosta.model.DeptDAO;
import com.kosta.model.DeptVO;
import com.kosta.model.LocationVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/dept/deptInsert")
public class DeptInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //수정하기
        // DB 입력목적
        request.setCharacterEncoding("utf-8");
        int did = convertInt(request.getParameter("dept_id")); //department_id
        String dname = request.getParameter("dept_name"); //department_name
        int mid = convertInt(request.getParameter("manager_id"));
        int locid = convertInt(request.getParameter("location_id"));

        DeptVO dept = new DeptVO(did, dname, mid, locid);
        DeptDAO dao = new DeptDAO();

        int result = 0;
        result = dao.insertDept(dept);

        System.out.println(result + "건 입력");
        request.setAttribute("message", result + "건 입력");

        //jsp에게 위임
        RequestDispatcher rd = request.getRequestDispatcher("resultInfo.jsp");
        rd.forward(request, response);
    }

    private int convertInt(String param) { //String -> int
        if(param == null) return 0;
        return Integer.parseInt(param);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 입력한 페이지 보여주기
        DeptDAO dao = new DeptDAO();
        request.setAttribute("loclist", dao.selectAllLocation());
        request.setAttribute("mlist", dao.selectAllManager());

        RequestDispatcher rd = request.getRequestDispatcher("deptInsert.jsp");
        rd.forward(request, response);
    }
}
