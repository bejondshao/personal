<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/25/16
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
用户名: <input type="text" id="username" name="username" value="${username}"/> <br/>
密码: <input type="password" id="password" name="password" value="${password}"/> <br/>
<button type="reset">重置</button> <button type="submit">提交</button>
    <font color="red">${error}</font>
</form>
</body>
</html>
