<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/9/16
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
<div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
        <span class="sr-only">40% Complete</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
        <span class="sr-only">60% Complete</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
        60%
    </div>
</div>
<p>在展示很低的百分比时，如果需要让文本提示能够清晰可见，可以为进度条设置 min-width 属性。</p>
<div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="100" style="min-width: 2em; width: 2%;">
        2%
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
        <span class="sr-only">40% Complete (success)</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
        <span class="sr-only">20% Complete</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
        <span class="sr-only">60% Complete (warning)</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
        <span class="sr-only">80% Complete (danger)</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
        <span class="sr-only">40% Complete (success)</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
        <span class="sr-only">20% Complete</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
        <span class="sr-only">60% Complete (warning)</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
        <span class="sr-only">80% Complete (danger)</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
        <span class="sr-only">45% Complete</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-success" style="width: 35%">
        <span class="sr-only">35% Complete (success)</span>
    </div>
    <div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 20%">
        <span class="sr-only">20% Complete (warning)</span>
    </div>
    <div class="progress-bar progress-bar-danger" style="width: 10%">
        <span class="sr-only">10% Complete (danger)</span>
    </div>
</div>
</body>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="../bootstrap3/js/jquery-2.2.3.min.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="../bootstrap3/js/bootstrap.min.js"></script>
</html>
