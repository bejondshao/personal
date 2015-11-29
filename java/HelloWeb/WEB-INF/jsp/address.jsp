<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" action="/HelloWeb/addStudent">
    <table>
        <tr>
            <td><form:label path="code">Code</form:label></td>
            <td><form:input path="code" /></td>
        </tr>
        <tr>
            <td><form:label path="street">Street</form:label></td>
            <td><form:input path="street" /></td>
        </tr>
        <tr>
            <td><form:label path="streetNumber">StreetNumber</form:label></td>
            <td><form:input path="streetNumber" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>