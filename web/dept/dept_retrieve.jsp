<%@ page import="com.kosta.model.DeptVO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: f1c04
  Date: 21. 4. 13.
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        td {
            padding: 5px;
        }

        tr:first-of-type {
            background-color: hotpink;
        }
    </style>
    <%
        List<DeptVO> dlist = (List<DeptVO>) request.getAttribute("deptall");
    %>
</head>
<body>
<h1>부서목록</h1>
<a href="deptInsert">신규등록</a>
<hr>
<table>
    <tr>
        <td>부서코드</td>
        <td>부서이름</td>
        <td>매니저</td>
        <td>location</td>
    </tr>
    <%for (DeptVO dept : dlist) { %>
    <tr>
        <td><a href="deptDetail?deptid=<%=dept.getDept_id()%>"><%=dept.getDept_id()%>
        </a></td>
        <td><%=dept.getDept_name() %>
        </td>
        <td><%=dept.getManager_id() %>
        </td>
        <td><%=dept.getLocation_id() %>
        </td>
        <td>
            <button onclick="location.href='deptDelete?deptid=<%=dept.getDept_id()%>'">삭제</button>
        </td>
    </tr>
    <%} %>
</table>

</body>
</html>
