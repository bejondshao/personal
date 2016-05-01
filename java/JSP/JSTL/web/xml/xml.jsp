<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/1/16
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../init.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="usersInfo.xml" var="usersInfo" charEncoding="UTF-8"></c:import>
<x:parse doc="${usersInfo}" var="usersInfoXml"/>
<h4>姓名: <x:out select="$usersInfoXml/users/user/name"/></h4>
<h4>ID: <x:out select="$usersInfoXml/users/user/name/@id"/></h4>
<h4>生日: <x:out select="$usersInfoXml/users/user/birthday"/></h4>
<x:set var="userInfoXml" select="$usersInfoXml/users/user"/>
<h4>姓名: <x:out select="$userInfoXml/name"/></h4>

<x:if select="$userInfoXml/name/@id = 'n1'">
    有编号为n1的用户
</x:if>
<br/>
<x:choose>
    <x:when select="$userInfoXml/name/@id = 'n2'">
        有编号为n2的用户
    </x:when>
    <x:otherwise>
        没有编号为n2的用户
    </x:otherwise>
</x:choose>
<br/>

<c:import url="usersInfo2.xml" var="usersInfo2" charEncoding="UTF-8"/>
<x:parse var="users" doc="${usersInfo2}"/>
<x:forEach select="$users/users/user" var="user">
    <x:out select="$user/name"></x:out> - <x:out select="$user/name/@id"></x:out><br/>
</x:forEach>
</body>
</html>
