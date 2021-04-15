package com.kosta.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;
import com.kosta.util.ConvertUtil;

import static com.kosta.util.ConvertUtil.convertInt;

/**
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/emp/empUpdate")
public class EmpUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpVO emp = new EmpVO();
        emp.setCommission_pct(ConvertUtil.convertDouble(request.getParameter("emp_comm")));
        emp.setDepartment_id(ConvertUtil.convertInt(request.getParameter("emp_department_id")));
        emp.setEmail(request.getParameter("emp_email"));
        emp.setEmployee_id(ConvertUtil.convertInt(request.getParameter("emp_id")));
        emp.setFirst_name(request.getParameter("emp_fname"));
        emp.setHire_date(ConvertUtil.convertDate(request.getParameter("emp_hire_date")));
        emp.setJob_id(request.getParameter("emp_job_id"));
        emp.setLast_name(request.getParameter("emp_lname"));
        emp.setManager_id(ConvertUtil.convertInt(request.getParameter("emp_manager_id")));
        emp.setPhone_number(request.getParameter("emp_phone"));
        emp.setSalary(ConvertUtil.convertInt(request.getParameter("emp_salary")));

        EmpDAO dao = new EmpDAO();
        int result = dao.updateEmp(emp);

        String message = result>0?"수정성공":"수정실패";
        request.setAttribute("message", message);

        //응답문서의 header정보 변경하기
        //response.setHeader("refresh", "3;url=emplist");

        //RequestDispatcher rd = request.getRequestDispatcher("resultInfo.jsp");
        //rd.forward(request, response);

        //주소창이 변경됨. 요청 재지정(변경)
        request.setAttribute("info", "요청재지정시 request는 전달안됨");
        response.sendRedirect("emplist");
    }
}