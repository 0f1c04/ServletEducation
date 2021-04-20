<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL태그연습</h1>
<c:set var="count" value="10"/>
<c:set var="count" value="${count+1}"/>
현재 count: ${count}<br>

<img alt="이미지1" src="image/duke.png">
<c:set var="appPath" value="${pageContext.request.contextPath}"/>
${appPath}<br>
<img alt="이미지1" src="image/duke2.png">
<img alt="이미지1" src="${appPath}/jsptest/image/duke2.png">

<hr>
<h2>반복문</h2>
<c:forEach begin="1" end="10" var="su">
    <c:set var="total" value="${total+su}"/>
    <p>${su}</p>
</c:forEach>
합계:${total}

</body>
</html>
