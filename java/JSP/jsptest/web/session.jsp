<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/19/16
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("name", "session哈哈");
    session.setAttribute("age", 22);
%>
<h4>由于数据存储在session中,数据就存在服务器的内存中, 不需要forward, 可以在另一个页面中直接获取值</h4>
</body>
</html>
