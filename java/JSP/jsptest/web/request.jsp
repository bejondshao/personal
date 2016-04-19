<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/19/16
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("name", "request小小");
    request.setAttribute("age", 22);
%>
<jsp:forward page="request_target.jsp"></jsp:forward>
</body>
</html>
