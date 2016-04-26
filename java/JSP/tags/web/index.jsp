<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/25/16
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="/WEB-INF/tags.tld" %>
<%@ page import="java.util.*" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
      List list = new ArrayList();
      list.add("DDD");
      list.add("小哈哈");
      list.add("猝不及防");

      pageContext.setAttribute("list", list);
  %>
  <b:helloTag name="hahaha"/>
  <b:iterate value="name6" items="list">
        <h4>${name6}</h4>
  </b:iterate>
  <b:reverseTag bold="true">asdfghjkl</b:reverseTag>
  <b:reverseTag bold="false">asd fgh jkl</b:reverseTag>
  </body>
</html>
