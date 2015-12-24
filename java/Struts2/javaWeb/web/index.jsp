<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 15-12-21
  Time: 下午1:25
  To change this template use File | Settings | File Templates.
--%>
<% String contextPath = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
This is a java web project.
使用Domain Model接收参数<a href="<%= request.getContextPath() %>/Student_add?student.name=a&student.age=8">添加学生</a>
Model Driven接收参数 <a href="<%= contextPath %>/Book_add?name=github&price=11.2&pages=123" >添加图书</a>
  </body>
</html>
