<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 2/29/16
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="init_user.jsp" %>

<s:iterator value="userList">
    <s:property value="username" />
</s:iterator>
