<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/25/16
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="EL2.jsp" method="get">
    <input type="text" name="name">
    <input type="submit" value="提交">
</form>
<form action="EL2.jsp" method="post">
    <input type="checkbox" name="hobby" value="篮球">篮球
    <input type="checkbox" name="hobby" value="足球">足球
    <input type="checkbox" name="hobby" value="羽毛球">羽毛球
    <input type="submit" value="提交">
</form>
</body>
</html>
