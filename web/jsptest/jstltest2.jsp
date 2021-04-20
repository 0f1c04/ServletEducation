<%--
  Created by IntelliJ IDEA.
  User: f1c04
  Date: 21. 4. 20.
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/emp/empDetail" var="empD">
    <c:param name="empid" value="100"></c:param>
</c:url>
<a href="${empD}">100번 상세보기</a>
<c:redirect url="/emp/empDetail">
    <c:param name="empid" value="100"></c:param>
</c:redirect>
</body>
</html>
