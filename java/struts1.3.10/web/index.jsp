<%@ page pageEncoding="GBK"%>
<%-- ����Struts tag--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<head>
  <title>������</title>
</head>
<body>
<table align="center" cellpadding="10" width="100%">
  <tr>
    <td align="right" width="50%">
      <%-- ʹ��Struts tag--%>
      <html:link forward="newProduct">¼���Ʒ��Ϣ</html:link>
    </td>
    <td>
      <html:link forward="searchProduct">��ѯ��Ʒ��Ϣ</html:link>
    </td>
    <a href="login.jsp" >login</a>
  </tr>
</table>
</body>
</html>
