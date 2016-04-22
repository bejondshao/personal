<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/21/16
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Init</title>
</head>
<body>
<%
    String pageName = config.getInitParameter("pageName");
    String usages = config.getInitParameter("usages");
%>
<h4>
    页面名称: <%= pageName %><br />
    用途: <%= usages %><br />
</h4>
</body>
</html>
