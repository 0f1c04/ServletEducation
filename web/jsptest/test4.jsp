<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>test4.jsp</h1>
<jsp:useBean id="dept2" class="com.kosta.model.DeptVO" scope="request"></jsp:useBean>
<%--<jsp:setProperty property="dept_id" name="dept2" value="212" param="dept_id"/>--%>
<%--<jsp:setProperty property="location_id" name="dept2" value="212613" param="location_id"/>--%>
<%--<jsp:setProperty property="dept_name" name="dept2" value="상혁부서" param="dept_name"/>--%>
<%--<jsp:setProperty property="manager_id" name="dept2" value="0212" param="manager_id"/>--%>
<jsp:setProperty name="dept2" property="*"/>

department_id : <jsp:getProperty property="dept_id" name="dept2"/><br>
department_name : <jsp:getProperty property="dept_name" name="dept2"/><br>
location_id : <jsp:getProperty property="location_id" name="dept2"/><br>
manager_id : <jsp:getProperty property="manager_id" name="dept2"/>
</body>
</html>