<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/1/16
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../init.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("info", "www.google.com.hk");
%>
<h4>查找google的位置: ${fn:indexOf(info, "google")}</h4>
<h4>转换大写: ${fn:toUpperCase(info)}</h4>
<h4>截取部分: ${fn:substring(info, 1, 5)}</h4>
<h4>拆分: ${fn:split(info, ".")[2]}</h4>
</body>
</html>
