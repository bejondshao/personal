<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/28/16
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("date", new Date());
%>
<fmt:setLocale value="zh_CN"/>
日期: <fmt:formatDate value="${date}"/><br/>

<fmt:setLocale value="en_US"/>
Date: <fmt:formatDate value="${date}"/><br/>
<hr/>
<fmt:requestEncoding value="UTF-8"/>
<hr/>
<fmt:setLocale value="zh_CN"/>
<fmt:bundle basename="info">
    <fmt:message key="name" var="userName"/>
</fmt:bundle>
<h4>姓名: ${userName}</h4>
<fmt:setLocale value="en_US"/>
<fmt:bundle basename="info">
    <fmt:message key="name" var="userName"/>
    <fmt:message key="info" var="information">
        <fmt:param value="<font color='red'>小峰</font>"/>
    </fmt:message>
</fmt:bundle>
<h4>姓名: ${userName}</h4>
<h4>信息: ${information}</h4>
<hr/>
<fmt:formatNumber value="18" type="currency" pattern="$.00"/><br/>
<fmt:formatNumber value="18" type="currency" pattern="$.0#"/><br/>
<fmt:formatNumber value="1234567890" type="currency"/><br/>
<fmt:formatNumber value="12345.6789" pattern="#,#00.0#"/><br/>
<hr/>
<%
    Date date = new Date();
    pageContext.setAttribute("date", date);
%>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/><br/>
格林尼治时间:
<fmt:timeZone value="GMT">
    <fmt:formatDate value="${date}" pattern="dd-MM-yyyy HH:mm:ss"/><br/>
</fmt:timeZone>
<hr/>
</body>
</html>
