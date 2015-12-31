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

    <title>OGNL</title>
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
<li>访问value stack contents中的action普通属性: username = <s:property value="username" /> </li>
<li>访问值栈中对象的普通属性(get set方法)：<s:property value="student.age"/> | <s:property value="student['age']" /> | <s:property value="student[\"age\"]" /> | wrong: <%--<s:property value="user[age]"/>--%> </li>
<li>访问值栈中对象的普通属性(get set方法)：<s:property value="book.name"/> | <s:property value="book['name']" /> | <s:property value="book[\"name\"]" /> | wrong: <%--<s:property value="user[age]"/>--%> </li></li>
<li>访问值栈中对象的普通属性(get set方法): <s:property value="cat.friend.name"/></li>
<li>访问值栈中对象的普通方法：<s:property value="password.length()"/></li>
<li>访问值栈中对象的普通方法：<s:property value="cat.miao()" /></li>
<li>访问值栈中action的普通方法：<s:property value="m()" /></li>

<li>访问静态方法：<s:property value="@com.bejond.staticpackage.Static@s()"/></li>
<li>访问静态属性：<s:property value="@com.bejond.staticpackage.Static@NAME"/></li>
<li>访问Math类的静态方法：<s:property value="@ @max(2,3)" /></li>
<s:debug />
</body>
</html>
