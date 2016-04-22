<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/21/16
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
啊偶, 好像出问题了.

<%
    if (exception != null) {
        out.println(exception.getCause());
        out.println(exception.getMessage());
        out.println(exception.getStackTrace());
    }
%>
</body>
</html>
