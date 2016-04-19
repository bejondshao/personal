<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/19/16
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Enumeration enumeration = request.getHeaderNames();
    String headerName = null;
    String headerValue = null;

    while (enumeration.hasMoreElements()) {
        headerName = (String)enumeration.nextElement();
        headerValue = request.getHeader(headerName);
%>
<h4><%= headerName %>&nbsp;<%= headerValue %>
<%
    }
%>

    <font>姓名: <%= request.getAttribute("name") %></font>
    <font>年龄: <%= request.getAttribute("age") %></font>
</body>
</html>
