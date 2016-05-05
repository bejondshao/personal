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
    <title>Bootstrap</title>
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
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1 c">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1 c">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
    </div>
    <div class="row">
        <div class="col-md-8 c">.col-md-8</div>
        <div class="col-md-4">.col-md-4</div>
    </div>
    <div class="row">
        <div class="col-md-4">.col-md-4</div>
        <div class="col-md-4">.col-md-4</div>
        <div class="col-md-4">.col-md-4</div>
    </div>
    <div class="row">
        <div class="col-md-6 c">.col-md-6</div>
        <div class="col-md-6">.col-md-6</div>
    </div>
</div>
<hr/>
<div class="container">
    <div class="row">
        <div class="col-md-4 c">.col-md-4</div>
        <div class="col-md-4 col-md-offset-3 c">.col-md-4 offset-3</div>
    </div>
    <div class="row">
        <div class="col-md-3 col-md-offset-3 c">.col-md-3 .col-md-offset-3</div>
        <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3 c">.col-md-6 .col-md-offset-3</div>
    </div>
</div>
<hr/>
<div class="container">
    <div class="row b">
        <div class="col-sm-9 c">
            Level 1: .col-sm-9
        </div>
        <div class="row c">
            <div class="col-xs-8 col-sm-4 d">
                Level 2: .col-xs-8 .col-sm-4
            </div>
            <div class="col-xs-4 col-sm-6 d">
                Level 2: .col-xs-4 .col-sm-6
            </div>
        </div>
    </div>
</div>
</body>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="../bootstrap3/js/jquery-2.2.3.min.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="../bootstrap3/js/bootstrap.min.js"></script>
</html>
