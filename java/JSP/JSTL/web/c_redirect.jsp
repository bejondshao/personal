<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/27/16
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:redirect url="target.jsp">
    <c:param name="name" value="bejondshao"></c:param>
    <c:param name="age" value="18"></c:param>
</c:redirect>
</body>
</html>
