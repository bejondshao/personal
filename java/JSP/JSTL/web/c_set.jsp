<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/26/16
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="user1" value="张飞" scope="request"></c:set>
<c:out value="${user1}"></c:out><br/>
<jsp:useBean id="user2" class="com.bejond.jstl.model.User" scope="page"></jsp:useBean>
<c:set property="id" target="${user2}" value="100"></c:set>
<c:set property="name" target="${user2}" value="李逵"></c:set>
<c:set property="age" target="${user2}" value="18"></c:set>
<c:out value="序号: ${user2.id}"></c:out><br/>
<c:out value="姓名: ${user2.name}"></c:out><br/>
<c:out value="年龄: ${user2.age}"></c:out><br/>

<c:remove var="user2" scope="page"/>
<c:out value="${user2}" default="没人啊"></c:out><br/>

<c:catch var="errorMessage">
    <%
        int a = 1/0;
    %>
</c:catch>
<c:out value="异常信息: ${errorMessage}"></c:out><br/>

<c:if test="${user2 == null}" scope="page" var="result">
    <c:out value="user2不存在"></c:out><br/>
</c:if>

<%
    int number = 3/2;
%>
<c:choose>
    <c:when test="<%= number > 2 %>">
        <c:out value="number > 2: "></c:out><%= number %><br/>
    </c:when>
    <c:when test="<%= number < 1 %>">
        <c:out value="number < 1: "></c:out><%= number %><br/>
    </c:when>
    <c:otherwise>
        <c:out value="1 < number < 2: "></c:out><%= number %><br/>
    </c:otherwise>
</c:choose>
</body>
</html>
