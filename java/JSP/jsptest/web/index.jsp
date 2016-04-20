<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/19/16
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
      pageContext.setAttribute("name", "page张飞");
      pageContext.setAttribute("age", 25);
  %>
  <%
      String name = (String)pageContext.getAttribute("name");
      int age = (Integer)pageContext.getAttribute("age");
  %>

  <font>姓名: <%= name %></font>
  <font>年龄: <%= age %></font>
  </body>
</html>
