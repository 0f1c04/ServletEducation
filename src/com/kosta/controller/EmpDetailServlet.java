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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //수정하기
        request.setCharacterEncoding("utf-8");
        int eid = convertInt(request.getParameter("emp_id"));
        String empFname = request.getParameter("emp_fname");
        String empLname = request.getParameter("emp_lname");
        String email = request.getParameter("emp_email");
        String phone = request.getParameter("emp_phone");
        Date hireDate = ConvertUtil.convertDate(request.getParameter("emp_hire_date"));
        String jobID = request.getParameter("emp_job_id");
        int salary = convertInt(request.getParameter("emp_salary"));
        double comm = Double.parseDouble(request.getParameter("emp_comm"));
        int managerID = convertInt(request.getParameter("emp_manager_id"));
        int departID = convertInt(request.getParameter("emp_depart_id"));

        EmpVO emp = new EmpVO(eid, empFname, empLname, email, phone, hireDate, jobID, salary,
                comm, managerID, departID);
        EmpDAO dao = new EmpDAO();

        int result = 0;
        result = dao.updateEmp(emp);

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
        String emp_id = request.getParameter("emp_id");
        int i_empid = Integer.parseInt(emp_id);
        EmpDAO dao = new EmpDAO();
        EmpVO emp = dao.selectById(i_empid);
        request.setAttribute("emp", emp);

        // jsp에게 위임
        RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
        rd.forward(request, response);
    }
}
