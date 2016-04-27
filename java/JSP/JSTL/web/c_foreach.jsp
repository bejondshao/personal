<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/27/16
  Time: 3:03 PM
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
    String cats[] = {"小花", "小红", "小喵", "小小"};

    pageContext.setAttribute("cats", cats);
%>
<c:forEach var="cat" items="${cats}" step="2" begin="1" end="4">
    ${cat}
</c:forEach>
<br/>
<%
    List<User> userList = new ArrayList<User>();
    userList.add(new User("Bejond", 18));
    userList.add(new User("David", 19));
    userList.add(new User("John", 17));

    pageContext.setAttribute("userList", userList);
%>
<c:forEach var="user" items="${userList}">
    ${user.name}<br/>
    ${user.age}<br/>
</c:forEach>
</body>
</html>
