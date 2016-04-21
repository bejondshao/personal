<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/20/16
  Time: 20:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp" %>
<html>
<head>
    <title>response 重定向</title>
    <%--<script type="text/javascript" src="js/main.js"></script>--%><%-- can't export resources to artifacts --%>
    <script type="text/javascript">
        function resetValue() {
            document.getElementById("username").value = "";
            document.getElementById("password").value = "";
        }
    </script>
<%
    String username = "";
    String password = "";
    Cookie[] cookies = request.getCookies();

    for (int i = 0; cookies != null && i < cookies.length; i++) {
        if (cookies[i].getName().equals("usernameAndPassword")) {
            username = cookies[i].getValue().split("_")[0];
            username = cookies[i].getValue().split("_")[1];
        }
    }
%>
</head>
<body>
<form action="user_login.jsp" method="post">
<table>
    <tr>
        <td>
            用户名:
        </td>
        <td>
            <input type="text" id="username" name="username" value="<%= username %>"/>
        </td>
    </tr>
    <tr>
        <td>
            密码:
        </td>
        <td>
            <input type="password" id="password" name="password" value="<%= password %>"/>
        </td>
    </tr>
    <tr>
        <td>
            记住密码:
        </td>
        <td>
            <input type="checkbox" id="remember" name="remember" value="remember-me" />
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" id="reset" name="reset" value="重置" onclick="resetValue()"/>
        </td>
        <td>
            <input type="submit" value="登录">
        </td>
    </tr>
</form>
</table>
<%
    out.println("out print");
    out.println(out.getBufferSize());
    out.println(out.getRemaining());
%>
</body>
</html>
