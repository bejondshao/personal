<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/20/16
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String rememberMe = request.getParameter("remember");
%>
用户名: <%= username %> <br />
<%
    if ("remember-me".equals(rememberMe)) {
        Cookie usernameAndPassword = new Cookie("usernameAndPassword", username + "_" + password);
        usernameAndPassword.setMaxAge(60 * 60 * 24); // 单位是秒
        response.addCookie(usernameAndPassword); // 保存Cookie
        System.out.println("设置Cookie成功");
    }
%>
</body>
</html>
