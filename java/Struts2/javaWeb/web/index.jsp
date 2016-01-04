<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 15-12-21
  Time: 下午1:25
  To change this template use File | Settings | File Templates.
--%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
This is a java web project.
使用Domain Model接收参数<a href="<%= request.getContextPath() %>/Student_add?student.name=a&student.age=8">添加学生</a>
Model Driven接收参数 <a href="<%= path %>/Book_add?name=github&price=11.2&pages=123" >添加图书</a>
  中文乱码<a href="<%= path %>/add_user.jsp">添加用户</a>
 <a href="<%= path %>/login.jsp">登录</a>
<br />
<a href="<%= path %>/ognl/ognl?username=bejond&password=asdf&student.age=29&cat.friend.name=Ohdy">ognl</a> <br />
<a href="<%= path %>/ognl/test">Chain Test Action</a>
  </body>
</html>
