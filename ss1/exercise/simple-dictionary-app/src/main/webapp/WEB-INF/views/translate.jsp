<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/15/2022
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>DỊCH TỪ ĐƠN GIẢN</h1>
<form action="begin" method="get">
    <div>
        <lable for="keyword"> Nhập từ muốn dich sang tiếng việt</lable>
    </div>

    <div>
        <input type="text" id="keyword" name="keywork">
    </div>

    <div>
        <button>Dịch</button>
    </div>
</form>
<h3>Kết quả</h3>
<p>${resurt}</p>
</body>
</html>
