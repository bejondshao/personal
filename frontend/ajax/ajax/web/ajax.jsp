<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/3/16
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>
<div style="text-align: center">
    <div><input type="button" value="Ajax获取数据" onclick="loadName()">&nbsp;&nbsp;<input type="text" id="name"></div>
    <div><input type="button" value="Ajax像form表单一样获取数据" onclick="loadNameLikeForm('name2')">&nbsp;&nbsp;<input type="text" id="name2"></div>
    <div><input type="button" value="Ajax获取xml文件的内容" onclick="loadXmlFile('name3')">&nbsp;&nbsp;<p id="name3"></p></div>
</div>
</body>
</html>
