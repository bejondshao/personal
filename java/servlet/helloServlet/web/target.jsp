<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/24/16
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>目标页</title>
</head>
<body>
<h3>目标地址</h3>
request值: <%= request.getAttribute("requestKey") %> <br/>
session值: <%= session.getAttribute("sessionKey") %> <br/>
application值: <%= application.getAttribute("applicationKey") %> <br/>
</body>
</html>
