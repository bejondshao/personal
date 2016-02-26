<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 2/22/16
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="init.jsp" %>
<%
User user = new User();
user.setUsername(request.getParameter("username"));
user.setPassword(request.getParameter("password"));
String password2 = request.getParameter("password2");

UserManager userManager = new UserManagerImpl();
boolean userExists = userManager.userExists(user);
if (userExists) {
    response.sendRedirect("/register_fail");
    return;
}

userManager.addUser(user);

response.sendRedirect("register_success.jsp");
%>

