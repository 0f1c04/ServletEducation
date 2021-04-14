<%--
  Created by IntelliJ IDEA.
  User: f1c04
  Date: 21. 4. 13.
  Time: 오후 4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>해당 직원 상세보기 ... </h1>
<form action="empDetail" method="post">
    직원번호:<input type="number" value="${emp.employee_id}" name="emp_id"><br>
    성:<input type="text" value="${emp.first_name}" name="emp_fname"><br>
    이름:<input type="text" value="${emp.last_name}" name="emp_lname"><br>
    이메:<input type="text" value="${emp.email}" name="emp_email"><br>
    전화번호:<input type="text" value="${emp.phone_number}" name="emp_phone"><br>
    입사일(YYYYMMDD):<input type="text" value="${emp.hire_date}" name="emp_hire_date"><br>
    직무:<input type="text" value="${emp.job_id}" name="emp_job_id"><br>
    급여:<input type="number" value="${emp.salary}" name="emp_salary"><br>
    성과급:<input type="number" value="${emp.commission_pct}" name="emp_comm" step="0.01"><br>
    담당 매니저ID:<input type="number" value="${emp.manager_id}" name="emp_manager_id"><br>
    부서ID:<input type="number" value="${emp.department_id}" name="emp_depart_id"><br>

    <input type="submit" value="수정하기">
</form>
</body>
</html>
