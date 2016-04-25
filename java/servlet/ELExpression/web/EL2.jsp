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
    request.setCharacterEncoding("UTF-8"); // 处理jsp请求页面的值的乱码
%>
姓名: <h4>${param.name}</h4>
爱好一: <h4>${paramValues.hobby[0]}</h4>
爱好二: <h4>${paramValues.hobby[1]}</h4>
爱好三: <h4>${paramValues.hobby[2]}</h4>
</body>
</html>
