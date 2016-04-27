<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/27/16
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String string1 = "www.bejond.com";
    String string2 = "刘备, 关羽, 张飞";

    pageContext.setAttribute("string1", string1);
    pageContext.setAttribute("string2", string2);
%>
<c:forTokens items="${string1}" delims="." var="s1">
    ${s1}
</c:forTokens>
<c:forTokens items="${string2}" delims="," var="s1">
    ${s1}
</c:forTokens>
</body>
</html>
