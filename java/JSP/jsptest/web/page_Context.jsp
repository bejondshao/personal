<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/21/16
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContext</title>
</head>
<body>
<%
    pageContext.setAttribute("name", "PageContext");
    request.setAttribute("nameRequest", "RequestInfo");
    session.setAttribute("nameSession", "SessionInfo");
    application.setAttribute("nameApplication", "ApplicationInfo");

    out.println("pageContext: " + pageContext.getAttribute("name") + "<br />");
    out.println("request: " + request.getAttribute("nameRequest") + "<br />");
    out.println("session: " + session.getAttribute("nameSession") + "<br />");
    out.println("application: " + application.getAttribute("nameApplication") + "<br />");

    out.println("pageContext: " + pageContext.getAttribute("name") + "<br />");
    out.println("request: " + pageContext.getRequest().getAttribute("nameRequest") + "<br />");
    out.println("session: " + pageContext.getSession().getAttribute("nameSession") + "<br />");
    out.println("application: " + pageContext.getServletContext().getAttribute("nameApplication") + "<br />");
%>
</body>
</html>
