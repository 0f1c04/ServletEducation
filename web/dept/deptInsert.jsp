<%@ page import="com.kosta.model.LocationVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kosta.model.ManagerVO" %>
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
<h1>부서 신규 등록</h1>
<form action="deptInsert" method="post">
    부서번호:<input type="number" value="${dept.dept_id}" name="dept_id"><br>
    부서이름:<input type="text" value="${dept.dept_name}" name="dept_name"><br>
    매니저ID:
    <select name="manager_id">
        <%
            List<ManagerVO> mlist = (List<ManagerVO>) request.getAttribute("mlist");
            for (ManagerVO m : mlist) {
        %>
        <option value="<%=m.getManager_id()%>"><%=m.getFullname()%>
        </option>
        <% }%>
    </select>
    <br>
    LocationID:
    <select name="Location_id">
        <%
            List<LocationVO> loclist = (List<LocationVO>)request.getAttribute("loclist");
            for (LocationVO loc : loclist) {
        %>
        <option value="<%=loc.getLocation_id()%>"><%=loc.getCity()%>
        </option>
        <% }%>
    </select>
    <br>
    <input type="submit" value="입력하기">
</form>
</body>
</html>
