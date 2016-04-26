<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/26/16
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
      pageContext.setAttribute("aa", "啊啊啊");
  %>
  <c:out value="JSTL你好吗"></c:out>
  <c:out value="${aa}"></c:out>
  <c:out value="${b}" default="没内容啊"></c:out>
  </body>
</html>
