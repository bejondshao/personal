<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/22/16
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="student" scope="request" class="com.bejond.javabean.model.Student"/>
<jsp:setProperty name="student" property="*"/>
<%
    request.setCharacterEncoding("UTF-8");
    // String name = request.getParameter("name");
    // int age = (Integer) request.getParameter("age");

    // student.setName(name);
    // student.setAge(age);
%>

<h4>姓名: <%= student.getName() %></h4>
<h4>年龄: <%= student.getAge() %></h4>
</body>
</html>
