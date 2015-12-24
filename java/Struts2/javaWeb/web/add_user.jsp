<?xml version="1.0" encoding="GB18030" ?>
<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
  <base href="<%=basePath %>"/>
  <title>Insert title here</title>
</head>
<body>
使用action属性接收参数，测试中文问题
<form action="addUser" method="post">
  姓名：<input type="text" name="name"></input>
  <input type="submit" value="submit"/>
</form>


</body>
</html>