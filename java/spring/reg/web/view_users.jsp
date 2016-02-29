<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 16-2-29
  Time: 下午5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init_user.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<%

List<User> userList = userManager.viewUsers();
%>
<table>
  <c:forEach items="${userList}" var="item">
    <tr>
      <td><c:out value="${userList}" /></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
