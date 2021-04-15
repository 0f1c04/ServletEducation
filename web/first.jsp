<%--
  Created by IntelliJ IDEA.
  User: f1c04
  Date: 21. 4. 15.
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    application.setAttribute("myAge1", 10);
    session.setAttribute("myAge2", 20);
    request.setAttribute("myAge3", 30);
    pageContext.setAttribute("myAge4", 40);

    // servlet context 매개변수사용 (web.xml에 선언)
    String dbName = application.getInitParameter("dbname");
    String userid = application.getInitParameter("userid");

    RequestDispatcher rd = null;
    rd = request.getRequestDispatcher("second.jsp");
    //rd.forward(request, response);
    rd.include(request, response);
%>
<h1>first 페이지에서 저장 후 가져오기</h1>
<p>application myAge1:${myAge1}</p>
<p>session myAge2:${myAge2}</p>
<p>myAge3:${myAge3}</p> <!-- request가 없으므로 미출력-->
<p>pageContext myAge4:${myAge4}</p> <!-- pageContext는 자신의 페이지에서만 가능하므로 미출력 -->

<p><%=dbName%></p>
<p><%=userid%></p>

</body>
</html>
