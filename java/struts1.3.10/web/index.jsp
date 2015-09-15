<%@ page pageEncoding="GBK"%>
<%-- 引用Struts tag--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<head>
  <title>主界面</title>
</head>
<body>
<table align="center" cellpadding="10" width="100%">
  <tr>
    <td align="right" width="50%">
      <%-- 使用Struts tag--%>
      <html:link forward="newProduct">录入产品信息</html:link>
    </td>
    <td>
      <html:link forward="searchProduct">查询产品信息</html:link>
    </td>
    <a href="login.jsp" >login</a>
  </tr>
</table>
</body>
</html>
