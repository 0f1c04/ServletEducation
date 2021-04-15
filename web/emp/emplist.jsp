<%@ page import="com.kosta.model.EmpVO" %>
<%@ page import="java.util.List" %>
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
        List<EmpVO> elist = (List<EmpVO>) request.getAttribute("empall");
    %>
</head>
<body>
<h1>직원목록</h1>
<a href="empInsert">신규등록</a>
<hr>
<ul>
    <li>${myname}</li>
    <li><%=request.getAttribute("myscore")%></li>
    <li>${myemp}</li>
    <li>${info}</li>
</ul>
<table>
    <tr>
        <td>직원번호</td>
        <td>이름</td>
        <td>이메일</td>
        <td>전화번호</td>
        <td>입사일</td>
        <td>직무</td>
        <td>급여</td>
        <td>성과급</td>
        <td>매니저ID</td>
        <td>부서ID</td>
    </tr>
    <%for (EmpVO emp : elist) { %>
    <tr>
        <td><a href="empDetail?emp_id=<%=emp.getEmployee_id()%>"><%=emp.getEmployee_id()%>
        </a></td>
        <td><%=emp.getFirst_name() + " " + emp.getLast_name() %>
        </td>
        <td><%=emp.getEmail()%>
        </td>
        <td><%=emp.getPhone_number()%>
        </td>
        <td><%=emp.getHire_date()%>
        </td>
        <td><%=emp.getJob_id()%>
        </td>
        <td><%=emp.getSalary() %>
        </td>
        <td><%=emp.getCommission_pct()%>
        </td>
        <td><%=emp.getManager_id()%>
        </td>
        <td><%=emp.getDepartment_id() %>
        </td>
        <td>
            <button onclick="location.href='empDelete?emp_id=<%=emp.getEmployee_id()%>'">삭제</button>
        </td>
    </tr>
    <%} %>
</table>

</body>
</html>
