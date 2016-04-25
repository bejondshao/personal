<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/25/16
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bejond.ELExpression.model.User" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setId(1);
    user.setName("小哈");

    request.setAttribute("user11", user);
%>
${user11.name}<br/>
${user11.id}<br/>
<%
    List list = new LinkedList();
    list.add(0, "元素1");
    list.add(1, "元素2");
    list.add(2, "元素3");

    request.setAttribute("list", list);
%>
${list[1]}
</body>
</html>
