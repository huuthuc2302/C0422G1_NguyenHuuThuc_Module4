<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/update" method="post" modelAttribute="boxMail">
    <table>
        <tr>
            <td><b>Languages</b></td>
            <td><form:select path="language" items="${listLanguage}"/></td>
        </tr>
        <tr>
            <td><b>Page Size:</b></td>
            <td>Show <form:select path="pageSize" items="${listSize}"/> emails per page</td>
        </tr>
        <tr>
            <td><b>Spams filter:</b></td>
            <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td><b>Signature:</b></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><button type="submit">Update</button></td>
            <td><button>Cancel</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
