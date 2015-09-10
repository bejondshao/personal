<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 15-9-2
  Time: 上午11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello, \${userInfo["name"]}}</title>
  </head>
  <body>
  <%
    Map model = (Map)request.getAttribute("userInfo");
  %>
<h3>Hello, <%= model.get("name") %>!</h3>
  </body>
</html>
