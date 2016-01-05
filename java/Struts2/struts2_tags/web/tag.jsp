
<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 16-1-4
  Time: 下午3:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title></title>
</head>
<>
<li>property 取value的值: <s:property value="username" /> (value是Object类型，所有Object类型的属性，都会将其值解析为ognl表达式，因此会到value stack里取其值)</li>
<li>property 取value的字符串: <s:property value="'username'" /> ("'text'"用来表示普通字符串)</li>
<li>property 设定默认值: <s:property value="admin" default="管理员"/> </li>
<li>property 设定HTML: <s:property value="'&lt'" /> </li>
<li>property 设定HTML: <s:property value="'&lt'" escape="false"/> </li>
<hr />
<li>set 设定adminName值（默认为request 和 ActionContext）: <s:set var="adminName" value="username" /></li>
<li>set 从request取值: <s:property value="#request.adminName" /></li>
<li>set 从ActionContext取值: <s:property value="#adminName" /></li>
<li>set 设定adminName1值（默认为request 和 ActionContext）: <s:set var="adminName1" value="'username'" /></li>
<li>set 从request取值: <s:property value="#request.adminName1" /></li>
<li>set 从ActionContext取值: <s:property value="#adminName1" /></li>
<hr />
<li>set 设定范围: scope="page" <s:set name="adminPassword" value="password" scope="page"/></li>
<li>set 从相应范围取值: <%=pageContext.getAttribute("adminPassword") %></li>

<li>set 设定var，范围为ActionContext(默认值): <s:set var="adminPassword1" value="password"/></li>
<li>set 使用#取值: <s:property value="#adminPassword1"/> </li>

<li>set 设定var, 范围为session: <s:set var="adminPassword2" value="password" scope="session"/></li>
<li>set 从相应范围取值: <s:property value="#session.adminPassword2"/> </li>
<hr />
<li>bean, 定义bean, 生成新的对象，使用param来设定新的属性值:
    <s:bean name="com.bejond.model.Dog" var="myDog">
      <s:param name="name" value="'Hashiqi'" />
      <s:property value="name" />
      <s:property value="#myDog.name" />
      <%--<s:debug />--%>
    </s:bean>
</li>

<li>include标签, 不推荐用<br />
  <s:set var="incPage" value="'_include.html'" /> <%-- 这里的value是Object, 会按照ognl来读内容--%>
  <s:include value="%{#incPage}"></s:include> <%-- 这里的value是String, 会直接读内容--%>%{}表示将大括号里的内容当做ognl表达式读
</li>

<s:fielderror fieldName="fielderror.test" theme="simple" />

<li>if elseif else<br />
  <s:property value="#parameters.username[0]"></s:property> <br />

<li>if elseif else:
  age = <s:property value="#parameters.age[0]" /> <br />
  <s:set var="age" value="#parameters.age[0]" />
  <s:if test="#age < 0">wrong age!</s:if>
  <s:elseif test="#parameters.age[0] < 20">too young!</s:elseif>
  <s:else>yeah!</s:else><br />

</li>

<li>iterator标签 <br />
  <s:iterator value="{1,2,3,4,3,4,3}" >
    <s:property />
  </s:iterator>
</li>
<li>自定义变量：<br />
  <s:iterator value="{'aaa', 'bbb', 'ccc'}" var="x"> <%-- var相当于for each循环的临时变量 --%>
    <s:property value="#x.toUpperCase()"/> |
  </s:iterator>
</li>
<li>使用status:<br />
  <s:iterator value="{'aaa', 'bbb', 'ccc'}" status="status">
    <s:property/> |
    遍历过的元素总数：<s:property value="#status.count"/> |
    遍历过的元素索引：<s:property value="#status.index"/> |
    当前是偶数？：<s:property value="#status.even"/> |
    当前是奇数？：<s:property value="#status.odd"/> |
    是第一个元素吗？：<s:property value="#status.first"/> |
    是最后一个元素吗？：<s:property value="#status.last"/>
    <br />
  </s:iterator>
</li>
<li>定义map <br />
  <s:iterator value="#{1:'a', 2:'c', 3:'e'}">
    <s:property value="key" /> | <s:property value="value" /> <br />
  </s:iterator>
</li>
<li>
  <s:iterator value="#{1:'z', 2:'x', 3:'y'}" var="i">
    <s:property value="#i.key" /> | <s:property value="#i.value" /> <br />
  </s:iterator>
</li>

<s:debug />
</body>
</html>
