<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/12/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CHUYỂN ĐỔI TIỀN TỆ</h1>
<form action="app" method="get">
    <label for="money">Nhập số tiền $ muốn chuyển đổi: </label>
    <input type="text" id="money" name="money">
    <br>
    <p>1$ = 23.000 VND</p>
    <button>Chuyển đổi</button>
</form>
<h3>Số tiền $ sau khi chuyển đổi</h3>
<p>${result} VNĐ</p>
</body>
</html>
