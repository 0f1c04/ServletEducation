<%@ page import="com.kosta.model.JobVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kosta.model.ManagerVO" %>
<%@ page import="com.kosta.model.DepartmentVO" %>
<%@ page import="com.kosta.model.EmpVO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>해당 직원 상세보기 ... </h1>
<h1>${appInfo}</h1> <!-- servlet context 연습 -->
<form action="empUpdate" method="post">
    직원번호:<input type="number" value="${emp.employee_id}" name="emp_id"><br>
    성:<input type="text" value="${emp.first_name}" name="emp_fname"><br>
    이름:<input type="text" value="${emp.last_name}" name="emp_lname"><br>
    이메일:<input type="text" value="${emp.email}" name="emp_email"><br>
    전화번호:<input type="text" value="${emp.phone_number}" name="emp_phone"><br>
    입사일(YYYY-MM-DD):<input type="text" value="${emp.hire_date}" name="emp_hire_date"><br>
    직무:<select name="emp_job_id">
    <%
        String myJob = ((EmpVO) request.getAttribute("emp")).getJob_id();
        List<JobVO> joblist = (List<JobVO>) request.getAttribute("joblist");
        for (JobVO job : joblist) {
            String j = job.getJob_id();
    %>
    <option <%=myJob.equals(j) ? "selected" : ""%> value="<%=j%>"><%=job.getJob_title()%>
    </option>
    <% }%>
</select>
    <br>
    급여:<input type="number" value="${emp.salary}" name="emp_salary"><br>
    성과급:<input type="number" value="${emp.commission_pct}" name="emp_comm" step="0.01"><br>
    담당 매니저ID: <select name="emp_manager_id">
    <%
        int myManager = ((EmpVO) request.getAttribute("emp")).getManager_id();
        List<ManagerVO> mlist = (List<ManagerVO>) request.getAttribute("mlist");
        for (ManagerVO manager : mlist) {
            int m = manager.getManager_id();
    %>
    <option <%=myManager == m ? "selected" : ""%> value="<%=m%>"><%=manager.getFullname()%>
    </option>
    <% }%>
</select>
    <br>
    부서ID:
    <select name="emp_department_id">
        <%
            int myDept = ((EmpVO) request.getAttribute("emp")).getDepartment_id();
            List<DepartmentVO> dlist = (List<DepartmentVO>) request.getAttribute("dlist");
            for (DepartmentVO dept : dlist) {
                int d = dept.getDepartment_id();
        %>
        <option <%=myDept == d ? "selected" : ""%> value="<%=d%>"><%=dept.getDepartment_name()%>
        </option>
        <% }%>
    </select>
    <br>

    <input type="submit" value="수정하기">
</form>
</body>
</html>
