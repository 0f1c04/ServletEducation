<%@ page import="com.kosta.model.LocationVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kosta.model.ManagerVO" %>
<%@ page import="com.kosta.model.JobVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        form {
            border: 5px dotted green;
        }
    </style>
</head>
<body>
<h1>직원 신규 등록</h1>
<form action="empInsert" method="post">
    직원번호:<input type="number" name="emp_id"><br>
    성:<input type="text" name="emp_fname"><br>
    이름:<input type="text" name="emp_lname"><br>
    이메:<input type="text" name="emp_email"><br>
    전화번호:<input type="text" name="emp_phone"><br>
    입사일(YYYY-MM-DD):<input type="text" name="emp_hire_date"><br>
    직무:<select name="emp_job_id">
    <%
        List<JobVO> joblist = (List<JobVO>)request.getAttribute("joblist");
        for (JobVO job : joblist) {
    %>
    <option value="<%=job.getJob_id()%>"><%=job.getJob_title()%>
    </option>
    <% }%>
</select>
    <br>
    급여:<input type="number" name="emp_salary"><br>
    성과급:<input type="number" name="emp_comm" step="0.01"><br>
    담당 매니저ID: <select name="emp_manager_id">
    <%
        List<ManagerVO> mlist = (List<ManagerVO>) request.getAttribute("mlist");
        for (ManagerVO m : mlist) {
    %>
    <option value="<%=m.getManager_id()%>"><%=m.getFullname()%>
    </option>
    <% }%>
</select>
    <br>
    부서ID:<input type="number" name="emp_depart_id"><br>


    <input type="submit" value="입력하기">
</form>
</body>
</html>
