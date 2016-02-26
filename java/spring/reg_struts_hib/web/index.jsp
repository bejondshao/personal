<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 2/22/16
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="init.jsp" %>
<html>
  <head>
    <title>用户注册</title>
  </head>
  <body>
      <form method="post" action="test/regist.action">
          用户名: <input type="text" name="username"> <br>
          密码: <input type="password" name="password"> <br>
          重复密码: <input type="password" name="password2"> <br>

          <input type="submit" name="提交">
      </form><br>
  </body>
</html>
