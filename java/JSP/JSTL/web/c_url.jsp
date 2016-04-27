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
<c:url value="http://bejondshao.github.io" var="url">
    <c:param name="name" value="bejondshao"></c:param>
    <c:param name="age" value="18"></c:param>
</c:url>
<a href="${url}" name="personalBlog">个人博客</a>
</body>
</html>
