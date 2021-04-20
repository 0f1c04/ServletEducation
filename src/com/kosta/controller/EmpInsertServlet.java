package com.kosta.controller;

import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;
import com.kosta.util.ConvertUtil;
import com.kosta.util.UploadFileHelper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/emp/empInsert")
public class EmpInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //수정하기
        // DB 입력목적
        // request.setCharacterEncoding("utf-8");
        String UPLOAD_DIR = "upload";
        int size = 1024 * 1024 * 10; // 파일 사이즈 설정 : 10M
        // DefaultFileRenamePolicy 처리는 중복된 이름이 존재할 경우 처리할 때
        String path = getServletContext().getRealPath(UPLOAD_DIR);
        System.out.println(path);
        MultipartRequest mprequest =
                new MultipartRequest(request, path, size, "utf-8",
                        new DefaultFileRenamePolicy());

        // 전송한 전체 파일이름들을 가져온다.
        Enumeration files = mprequest.getFileNames();
        String str = (String) files.nextElement();

        // 파일명 중복이 발생했을 때 정책에 의해 뒤에 1,2,3 처럼 숫자가 붙어 고유 파일명을 생성한다.
        // 이때 생성된 이름을 FilesystemName이라고 하여 그 이름 정보를 가져온다. (중복 처리)
        //String fileName = mprequest.getFilesystemName(str);
        // 실제 파일 이름을 가져온다.
        String originalFileName = mprequest.getOriginalFileName(str);
        System.out.println(originalFileName);

        int eid = convertInt(mprequest.getParameter("emp_id"));
        String empFname = mprequest.getParameter("emp_fname");
        String empLname = mprequest.getParameter("emp_lname");
        String email = mprequest.getParameter("emp_email");
        String phone = mprequest.getParameter("emp_phone");
        Date hireDate = ConvertUtil.convertDate(mprequest.getParameter("emp_hire_date"));
        String jobID = mprequest.getParameter("emp_job_id");
        int salary = convertInt(mprequest.getParameter("emp_salary"));
        double comm = Double.parseDouble(mprequest.getParameter("emp_comm"));
        int managerID = convertInt(mprequest.getParameter("emp_manager_id"));
        int departID = convertInt(mprequest.getParameter("emp_depart_id"));

        EmpVO emp = new EmpVO(eid, empFname, empLname, email, phone, hireDate, jobID, salary, comm, managerID, departID);
        EmpDAO dao = new EmpDAO();

        int result = 0;
        result = dao.insertEmp(emp);

        System.out.println(result + "건 입력");
        request.setAttribute("message", result + "건 입력");

        //jsp에게 위임
        RequestDispatcher rd = request.getRequestDispatcher("resultInfo.jsp");
        rd.forward(request, response);
    }

    private int convertInt(String param) { //String -> int
        if (param == null) return 0;
        return Integer.parseInt(param);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 입력한 페이지 보여주기
        EmpDAO emp = new EmpDAO();
        request.setAttribute("joblist", emp.selectAllJobID());
        request.setAttribute("mlist", emp.selectAllManagerID());
        request.setAttribute("dlist", emp.selectAllDepartmentID());

        RequestDispatcher rd = request.getRequestDispatcher("empInsert.jsp");
        rd.forward(request, response);
    }
}
