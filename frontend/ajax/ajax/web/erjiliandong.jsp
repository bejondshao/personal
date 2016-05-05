<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/5/16
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二级联动</title>
    <script type="text/javascript" src="js/callback.js"></script>
</head>
<body>
省:
<select id="province" onchange="loadCities('province', city, 'loadInfo?action=loadCities')">
    <option value="1">辽宁</option><!-- 注意每个option属性是value,不是id -->
    <option value="2">吉林</option>
    <option value="3">黑龙江</option>
</select>
市:
<select id="city"></select>
</body>
</html>
