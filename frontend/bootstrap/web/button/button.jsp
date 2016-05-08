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
按钮<br/>
预定义样式<br/>
<!-- Standard button -->
<button type="button" class="btn btn-default">（默认样式）Default</button>

<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
<button type="button" class="btn btn-primary">（首选项）Primary</button>

<!-- Indicates a successful or positive action -->
<button type="button" class="btn btn-success">（成功）Success</button>

<!-- Contextual button for informational alert messages -->
<button type="button" class="btn btn-info">（一般信息）Info</button>

<!-- Indicates caution should be taken with this action -->
<button type="button" class="btn btn-warning">（警告）Warning</button>

<!-- Indicates a dangerous or potentially negative action -->
<button type="button" class="btn btn-danger">（危险）Danger</button>

<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
<button type="button" class="btn btn-link">（链接）Link</button>
尺寸<br/>
<p>需要让按钮具有不同尺寸吗？使用 .btn-lg、.btn-sm 或 .btn-xs 就可以获得不同尺寸的按钮。</p>
<p>
    <button type="button" class="btn btn-primary btn-lg">（大按钮）Large button</button>
    <button type="button" class="btn btn-default btn-lg">（大按钮）Large button</button>
</p>
<p>
    <button type="button" class="btn btn-primary">（默认尺寸）Default button</button>
    <button type="button" class="btn btn-default">（默认尺寸）Default button</button>
</p>
<p>
    <button type="button" class="btn btn-primary btn-sm">（小按钮）Small button</button>
    <button type="button" class="btn btn-default btn-sm">（小按钮）Small button</button>
</p>
<p>
    <button type="button" class="btn btn-primary btn-xs">（超小尺寸）Extra small button</button>
    <button type="button" class="btn btn-default btn-xs">（超小尺寸）Extra small button</button>
</p>
<p>通过给按钮添加 .btn-block 类可以将其拉伸至父元素100%的宽度，而且按钮也变为了块级（block）元素。</p>
<button type="button" class="btn btn-primary btn-lg btn-block">（块级元素）Block level button</button>
<button type="button" class="btn btn-default btn-lg btn-block">（块级元素）Block level button</button>
<p>激活状态</p>
<button type="button" class="btn btn-primary btn-lg active">Primary button</button>
<button type="button" class="btn btn-default btn-lg active">Button</button>
<p>链接元素</p>
<a href="#" class="btn btn-primary btn-lg active" role="button">Primary link</a>
<a href="#" class="btn btn-default btn-lg active" role="button">Link</a>
<p>禁用状态</p>
<button type="button" class="btn btn-lg btn-primary" disabled="disabled">Primary button</button>
<button type="button" class="btn btn-default btn-lg" disabled="disabled">Button</button>
</body>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="../bootstrap3/js/jquery-2.2.3.min.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="../bootstrap3/js/bootstrap.min.js"></script>
</html>
