<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 2/22/16
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="init.jsp" %>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
String password2 = request.getParameter("password2");

Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "");

String sqlQuery = "select count(*) from User where username = ?";
PreparedStatement preparedStatement0 = connection.prepareStatement(sqlQuery);
preparedStatement0.setString(1, username);
ResultSet resultSet = preparedStatement0.executeQuery();
resultSet.next();
int count = resultSet.getInt(1);
if(count > 0) {
    response.sendRedirect("register_fail.jsp");
    preparedStatement0.close();
    connection.close();
    return;
}

String sql = "insert into User values (?, ?, ?, ?)";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
Random random = new Random();
preparedStatement.setInt(1, random.nextInt());
preparedStatement.setString(2, password);
preparedStatement.setString(3, username);
preparedStatement.setInt(4, 7);
preparedStatement.executeUpdate();
connection.close();

response.sendRedirect("register_success.jsp");
%>

