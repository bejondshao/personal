<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/5/16
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/callback.js"></script>
</head>
<body>
<table>
    <tr>
        <td>用户注册</td>
    </tr>
    <tr>
        <td>用户名: </td>
        <td><input type="text" id="username" onblur="checkUsername('username', 'message', 'loadInfo?action=checkUsername')"><font id="message"></font></td>
    </tr>
    <tr>
        <td><button type="reset">重置</button></td>
        <td><button type="submit">注册</button></td>
    </tr>
</table>
</body>
</html>
