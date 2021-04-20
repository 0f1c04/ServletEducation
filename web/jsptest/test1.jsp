<%@page import="com.kosta.model.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>표준 Action tag > 'jsp:'으로 시작 > 들어오면 include/나가면 forward</h1>
<%-- <%
RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");
//rd.include(request, response); //이 페이지로 들어와라
rd.forward(request, response); //저 페이지로 가버려라
%> --%>

<%-- <jsp:include page="test2.jsp"></jsp:include>--%>



<%DeptVO dept = new DeptVO();
    dept.setDept_id(613);
    dept.setDept_name("재영부서");
    dept.setLocation_id(212613);
    dept.setManager_id(0613);
%>
<%=dept.getDept_id() %><br>
<jsp:useBean id="dept2" class="com.kosta.model.DeptVO" scope="request"></jsp:useBean>
<jsp:setProperty property="dept_id" name="dept2" value="212"/>
<jsp:setProperty property="location_id" name="dept2" value="212613"/>
<jsp:setProperty property="dept_name" name="dept2" value="상혁부서"/>
<jsp:setProperty property="manager_id" name="dept2" value="0212"/>

<jsp:forward page="test2.jsp"></jsp:forward>

department_id : <jsp:getProperty property="dept_id" name="dept2"/><br>
department_name : <jsp:getProperty property="dept_name" name="dept2"/><br>
location_id : <jsp:getProperty property="location_id" name="dept2"/><br>
manager_id : <jsp:getProperty property="manager_id" name="dept2"/>

</body>
</html>