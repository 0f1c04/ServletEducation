<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- getAttribute -->
ServletContext: ${scopeMessage1} <br> 
session: ${scopeMessage2} <br> 
request: ${scopeMessage3} <br> 

<!-- 제일 가까운거(범위가 좁은거) 읽음 -->
<h1>나의 이름은${myname}</h1> 
<!-- 각각 자기꺼 읽음 -->
<h1>나의 이름은${applicationScope.myname}</h1>
<h1>나의 이름은${sessionScope.myname}</h1>
<h1>나의 이름은${requestScope.myname}</h1>
</body>
</html>