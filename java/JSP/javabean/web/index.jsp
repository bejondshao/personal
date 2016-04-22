<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/22/16
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bejond.javabean.model.Student" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
        Student student = new Student(); // 尽量不要使用new
        student.setName("Bejond");
        student.setAge(18);
    %>

  <h4>姓名: <%= student.getName() %></h4>
  <h4>年龄: <%= student.getAge() %></h4>
  </body>
</html>
