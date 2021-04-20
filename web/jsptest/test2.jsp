<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>test2.jsp 입니다~0_0~</h1>
<jsp:useBean id="dept2" class="com.kosta.model.DeptVO" scope="request"></jsp:useBean>
department_id : <jsp:getProperty property="dept_id" name="dept2"/><br>
department_name : <jsp:getProperty property="dept_name" name="dept2"/><br>
location_id : <jsp:getProperty property="location_id" name="dept2"/><br>
manager_id : <jsp:getProperty property="manager_id" name="dept2"/>
</body>
</html>