<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/25/16
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("info1", "page范围的值");
    request.setAttribute("info2", "request范围的值");
    session.setAttribute("info3", "session范围的值");
    application.setAttribute("info4", "application范围的值");

    pageContext.setAttribute("info5", "page范围的值");
    request.setAttribute("info5", "request范围的值");
    session.setAttribute("info5", "session范围的值");
    application.setAttribute("info5", "application范围的值");
%>
<h4>${info1}</h4>
<h4>${info2}</h4>
<h4>${info3}</h4>
<h4>${info4}</h4>
<h4>${info5}</h4>
</body>
</html>
