
<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 16-1-4
  Time: 下午3:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title></title>
</head>
<body>
<li>property 取value的值: <s:property value="username" /> (value是Object类型，所有Object类型的属性，都会将其值解析为ognl表达式，因此会到value stack里取其值)</li>
<li>property 取value的字符串: <s:property value="'username'" /> ("'text'"用来表示普通字符串)</li>
<li>property 设定默认值: <s:property value="admin" default="管理员"/> </li>
<li>property 设定HTML: <s:property value="'&lt'" /> </li>
<li>property 设定HTML: <s:property value="'&lt'" escape="false"/> </li>
<hr />
<li>set 设定adminName值（默认为request 和 ActionContext）: <s:set var="adminName" value="username" /></li>
<li>set 从request取值: <s:property value="#request.adminName" /></li>
<li>set 从ActionContext取值: <s:property value="#adminName" /></li>
<li>set 设定adminName1值（默认为request 和 ActionContext）: <s:set var="adminName1" value="'username'" /></li>
<li>set 从request取值: <s:property value="#request.adminName1" /></li>
<li>set 从ActionContext取值: <s:property value="#adminName1" /></li>
<hr />
<li>set 设定范围: scope="page" <s:set name="adminPassword" value="password" scope="page"/></li>
<li>set 从相应范围取值: <%=pageContext.getAttribute("adminPassword") %></li>

<li>set 设定var，范围为ActionContext(默认值): <s:set var="adminPassword1" value="password"/></li>
<li>set 使用#取值: <s:property value="#adminPassword1"/> </li>

<li>set 设定var, 范围为session: <s:set var="adminPassword2" value="password" scope="session"/></li>
<li>set 从相应范围取值: <s:property value="#session.adminPassword2"/> </li>
<hr />

<s:debug />
</body>
</html>
