<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>HelloStruts2</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
This is loginFilter.jsp

<form name="loginForm" action="" method="post">
    用户名：<input type="text" name="name" />
    密码：<input type="password" name="password" />
    <br />
    <input type="button" value="submit1" onclick="javascript:document.loginForm.action='/login/login1';document.loginForm.submit();" />
    <input type="button" value="submit2" onclick="javascript:document.loginForm.action='/login/login2';document.loginForm.submit();" />
</form>
</body>
</html>
