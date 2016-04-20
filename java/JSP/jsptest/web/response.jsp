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
    <title>response自动刷新页面</title>
</head>
<body>
<%
    // 每隔三秒刷新一次页面
    response.setHeader("refresh", "3");
    Date date = new Date();
%>
当前时间: <%= date.toLocaleString() %>
</body>
</html>
