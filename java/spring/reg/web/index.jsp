<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 2/22/16
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="init_user.jsp" %>
<html>
  <head>
    <title>用户注册</title>
  </head>
  <body>
      <%--<a href="regist_user.jsp">用户注册</a> <br>--%>
      <s:action name="viewUser!viewUsers" executeResult="true" />
      <s:debug />
  </body>
</html>
