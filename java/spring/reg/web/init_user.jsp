<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 2/22/16
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ page import="com.bejond.model.User" %>
<%@ page import="com.bejond.service.UserManager" %>
<%@ page import="com.bejond.service.impl.UserManagerImpl" %>

<%@ page import="java.util.List" %>
<%
UserManager userManager = new UserManagerImpl();
%>