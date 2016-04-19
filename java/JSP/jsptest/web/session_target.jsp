<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/19/16
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<font>姓名: <%= session.getAttribute("name") %></font>
<font>年龄: <%= session.getAttribute("age") %></font>
</body>
</html>
