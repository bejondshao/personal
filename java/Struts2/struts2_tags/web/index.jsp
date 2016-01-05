<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 16-1-4
  Time: 下午3:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title></title>
  </head>
  <body>
  This is a java web project.
<a href="<%= path %>/tags/tag?username=bejond&password=test&age=12">Tags</a>
  </body>
</html>
