<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/19/16
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp" %>
<html>
<head>
    <title>response 重定向</title>
</head>
<body>
<%
    // 重定向, 客户端跳转
    response.sendRedirect("index.jsp");
%>
</body>
</html>
