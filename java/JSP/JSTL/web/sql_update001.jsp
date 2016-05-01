<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>设置JDBC连接</h1>
<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/db_jstl" user="root" password=""/>
<h1>添加数据</h1>
<sql:update var="result" >
	insert into t_student values(null,"008","草泥马","1991-1-1","男");
</sql:update>
<sql:update var="result" >
    update t_student set stuNo="010" where stuNo = "008";
</sql:update>
<sql:update var="result">
    delete from t_student where stuNo = "006";
</sql:update>
<sql:transaction>
    <sql:update var="result">
        insert into t_student values(null, "007", "林冲", "1859-03-02", "男");
    </sql:update>
</sql:transaction>
</body>
</html>