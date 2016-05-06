<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/5/16
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap - typesetting</title>
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含bootstrap样式表 -->
    <link rel="stylesheet" href="../bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap3/css/bootstrap-theme.min.css">
    <style type="text/css">
        .a {
            border: 2px solid red;
            background-color: lightcyan;
        }

        .b {
            border: 2px solid blue;
            background-color: lightcoral;
        }

        .c {
            border: 2px solid black;
            background-color: lightgoldenrodyellow;
        }

        .d {
            border: 1px solid cornflowerblue;
            background-color: lightpink;
        }
    </style>
</head>
<body>
<table class="table">
    <caption>Optional table caption.</caption>
    <thead>
        <tr>
            <th>编号</th>
            <th>产品</th>
            <th>交付时间</th>
            <th>状态</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>TB - Monthly</td>
            <td>01/04/2016</td>
            <td>Default</td>
        </tr>
        <tr>
            <td>1</td>
            <td>TB - Monthly</td>
            <td>01/04/2012</td>
            <td>Approved</td>
        </tr>
        <tr>
            <td>2</td>
            <td>TB - Monthly</td>
            <td>02/04/2012</td>
            <td>Declined</td>
        </tr>
        <tr>
            <td>3</td>
            <td>TB - Monthly</td>
            <td>03/04/2012</td>
            <td>Pending</td>
        </tr>
        <tr>
            <td>4</td>
            <td>TB - Monthly</td>
            <td>04/04/2012</td>
            <td>Call in to confirm</td>
        </tr>
    </tbody>
</table>
<table class="table table-striped">
    <caption>Optional table caption.</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>产品</th>
        <th>交付时间</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2016</td>
        <td>Default</td>
    </tr>
    <tr>
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2012</td>
        <td>Approved</td>
    </tr>
    <tr>
        <td>2</td>
        <td>TB - Monthly</td>
        <td>02/04/2012</td>
        <td>Declined</td>
    </tr>
    <tr>
        <td>3</td>
        <td>TB - Monthly</td>
        <td>03/04/2012</td>
        <td>Pending</td>
    </tr>
    <tr>
        <td>4</td>
        <td>TB - Monthly</td>
        <td>04/04/2012</td>
        <td>Call in to confirm</td>
    </tr>
    </tbody>
</table>
<table class="table table-bordered">
    <caption>Optional table caption.</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>产品</th>
        <th>交付时间</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2016</td>
        <td>Default</td>
    </tr>
    <tr>
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2012</td>
        <td>Approved</td>
    </tr>
    <tr>
        <td>2</td>
        <td>TB - Monthly</td>
        <td>02/04/2012</td>
        <td>Declined</td>
    </tr>
    <tr>
        <td>3</td>
        <td>TB - Monthly</td>
        <td>03/04/2012</td>
        <td>Pending</td>
    </tr>
    <tr>
        <td>4</td>
        <td>TB - Monthly</td>
        <td>04/04/2012</td>
        <td>Call in to confirm</td>
    </tr>
    </tbody>
</table>
<table class="table table-hover">
    <caption>Optional table caption.</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>产品</th>
        <th>交付时间</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2016</td>
        <td>Default</td>
    </tr>
    <tr>
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2012</td>
        <td>Approved</td>
    </tr>
    <tr>
        <td>2</td>
        <td>TB - Monthly</td>
        <td>02/04/2012</td>
        <td>Declined</td>
    </tr>
    <tr>
        <td>3</td>
        <td>TB - Monthly</td>
        <td>03/04/2012</td>
        <td>Pending</td>
    </tr>
    <tr>
        <td>4</td>
        <td>TB - Monthly</td>
        <td>04/04/2012</td>
        <td>Call in to confirm</td>
    </tr>
    </tbody>
</table>
<table class="table table-condensed">
    <caption>Optional table caption.</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>产品</th>
        <th>交付时间</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2016</td>
        <td>Default</td>
    </tr>
    <tr>
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2012</td>
        <td>Approved</td>
    </tr>
    <tr>
        <td>2</td>
        <td>TB - Monthly</td>
        <td>02/04/2012</td>
        <td>Declined</td>
    </tr>
    <tr>
        <td>3</td>
        <td>TB - Monthly</td>
        <td>03/04/2012</td>
        <td>Pending</td>
    </tr>
    <tr>
        <td>4</td>
        <td>TB - Monthly</td>
        <td>04/04/2012</td>
        <td>Call in to confirm</td>
    </tr>
    </tbody>
</table>
<table class="table">
    <caption>Optional table caption.</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>产品</th>
        <th>交付时间</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <tr class="active">
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2016</td>
        <td>Default</td>
    </tr>
    <tr class="success">
        <td>1</td>
        <td>TB - Monthly</td>
        <td>01/04/2012</td>
        <td>Approved</td>
    </tr>
    <tr class="info">
        <td>2</td>
        <td>TB - Monthly</td>
        <td>02/04/2012</td>
        <td>Declined</td>
    </tr>
    <tr class="warning">
        <td>3</td>
        <td>TB - Monthly</td>
        <td>03/04/2012</td>
        <td>Pending</td>
    </tr>
    <tr class="danger">
        <td>4</td>
        <td>TB - Monthly</td>
        <td>04/04/2012</td>
        <td>Call in to confirm</td>
    </tr>
    </tbody>
</table>
</body>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="../bootstrap3/js/jquery-2.2.3.min.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="../bootstrap3/js/bootstrap.min.js"></script>
</html>
