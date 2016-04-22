<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/22/16
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Use Bean</title>
</head>
<body>
<jsp:useBean id="student" scope="page" class="com.bejond.javabean.model.Student"/>
<%
    student.setName("Bejond");
    student.setAge(18);
%>

<h4>姓名: <%= student.getName() %></h4>
<h4>年龄: <%= student.getAge() %></h4>
</body>
</html>
