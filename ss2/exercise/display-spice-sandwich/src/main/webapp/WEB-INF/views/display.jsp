<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/option" method="post">
    <div>
        <c:forEach var="spice" items="${yourSpiceList}">
            <input type="checkbox" value="${spice}" name="chose">${spice}
        </c:forEach>
    </div>
    <div>
        <button type="submit">SAVE</button>
    </div>
</form>
<p>Sandwich of your choice includes spice : ${result}</p>
</body>
</html>
