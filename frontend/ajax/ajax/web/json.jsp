<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/4/16
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/callback.js"></script>
</head>
<body>
<button type="button" onclick="loadInfo('name', 'age', 'loadInfo?action=getInfo')">获取信息</button><br/>
姓名: <div id="name"></div>
年龄: <div id="age"></div>
<button type="button" onclick="loadInfo2('studentTable', 'loadInfo?action=getStudents')">获取信息2</button>
<table id="studentTable" border="1px">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>语文</th>
        <th>数学</th>
        <th>英语</th>
    </tr>
</table>
</body>
</html>
