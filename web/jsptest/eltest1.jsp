<%@ page import="com.kosta.model.DeptVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        request.setAttribute("mystr", "자바");
        request.setAttribute("myval", null);

        pageContext.setAttribute("score", 10);
        request.setAttribute("score", 20);
        session.setAttribute("score", 30);
        application.setAttribute("score", 40);

        String name = "jj";
        pageContext.setAttribute("name", name);

        pageContext.setAttribute("dept", new DeptVO(10, "개발부", 100, 1700));

        ArrayList<DeptVO> deptlist = new ArrayList<>();
        deptlist.add(new DeptVO(10, "개발부", 100, 1700));
        deptlist.add(new DeptVO(20, "개발부2", 100, 1700));
        deptlist.add(new DeptVO(30, "개발부3", 100, 1700));
        pageContext.setAttribute("deptlist", deptlist);

        HashMap<String, String> user = new HashMap<>();
        user.put("아이디", "userid1");
        user.put("이름", "username1");
        user.put("phone", "01-11-11");
        pageContext.setAttribute("user", user);

    %>
</head>
<body>
<h1>EL(expression Language</h1>
${10+2}<br>
${mystr}100<br>
${"자바"}100<br>
${10>20}<br>
${10 le 20}<br>
myval: ${myval}<br>
myval: ${myval + 10}<br>
empty: ${empty myval}<br>
parameter 읽기: ${param.age}<br>
scope사용(pageContext): ${score}<br>
scope사용(pageContext): ${pageScope.score}<br>
scope사용(request): ${requestScope.score}<br>
scope사용(session): ${sessionScope.score}<br>
scope사용(application): ${applicationScope.score}<br>
name: ${name}<br>
부서코드: ${dept.dept_id}<br>
부서이름: ${dept.dept_name}<br>
location_id: ${dept.location_id}<br>
manager_id: ${dept.manager_id}<br>
<hr>
collection연습:<br>
부서코드: ${deptlist[0].dept_id}<br>
부서이름: ${deptlist[0].dept_name}<br>
location_id: ${deptlist[0].location_id}<br>
manager_id: ${deptlist[0].manager_id}<br>
<br>
부서코드: ${deptlist[1].dept_id}<br>
부서이름: ${deptlist[1].dept_name}<br>
location_id: ${deptlist[1].location_id}<br>
manager_id: ${deptlist[1].manager_id}<br>
<hr>
map:<br>
${user["아이디"]}<br>
${user["이름"]}<br>
${user.phone}<br>
</body>
</html>
