<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 4/28/16
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="init.jsp" %>
<html>
<head>
    <title>Title</title>
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 包含bootstrap样式表 -->
    <link rel="stylesheet" href="bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap3/css/bootstrap-theme.min.css">
</head>
<body>
<h5>设置JDBC连接</h5>
<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/db_jstl" user="root" password=""/>
<sql:query var="result">
    select * from t_student;
</sql:query>
<h4>总记录数${result.rowCount}</h4>
<table class="table">
    <tr>
        <th>编号</th>
        <th>学号</th>
        <th>姓名</th>
        <th>出生日期</th>
        <th>性别</th>
    </tr>
    <c:forEach var="student" items="${result.rows}">
        <tr>
            <td>${student.id}</td>
            <td>${student.stuNo}</td>
            <td>${student.stuName}</td>
            <td>${student.birthday}</td>
            <td>${student.sex}</td>
        </tr>
    </c:forEach>
</table>
<h4>添加数据</h4>
<sql:update var="result">
    insert into t_student values(null, "006", "林冲", "1859-03-02", "男");
</sql:update>
</body>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="bootstrap3/js/jquery-2.2.3.min.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="bootstrap3/js/bootstrap.min.js"></script>
</html>
