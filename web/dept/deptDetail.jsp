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
<h1>부서 상세보기 ... ${myname}</h1>
<form action="deptDetail" method="post">
    부서번호:<input type="number" value="${dept.dept_id}" name="dept_id"><br>
    부서이름:<input type="text" value="${dept.dept_name}" name="dept_name"><br>
    매니저ID:<input type="number" value="${dept.manager_id}" name="manager_id"><br>
    LocationID:<input type="number" value="${dept.location_id}" name="location_id"><br>
    <input type="submit" value="수정하기">
</form>
</body>
</html>
