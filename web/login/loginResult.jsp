<%@page import="java.net.URLDecoder"%>
<%@ page import="com.kosta.listener.LoginImpl" %>
<%@ page import="com.kosta.model.EmpVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>로그인한 결과 출력하기 :  ${username } </h1>
<h2>${emp }</h2>
<p>${param.userid }</p>
<p>${param.userpw }</p>
<p>${param.address }</p>
<p>${param.phone }</p>
<p>total_user : <%=LoginImpl.getTotal_user()%></p>
<h2>현재 접속자들</h2>
<%
    List<EmpVO> ulist = (List<EmpVO>)application.getAttribute("user_list");
    if(ulist == null) return;
    for(EmpVO emp:ulist) {
        out.print(emp + "<br>");
    }
%>
</body>
</html>