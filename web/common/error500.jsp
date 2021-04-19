<%--
  Created by IntelliJ IDEA.
  User: f1c04
  Date: 21. 4. 19.
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>오류입니다.</h1>
<hr>
<%=exception.toString()%>
<hr>
오류메시지: <%=exception.getMessage()%>
<hr>
<%exception.printStackTrace();%>
</body>
</html>
