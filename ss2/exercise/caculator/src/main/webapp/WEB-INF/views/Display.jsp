<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate" method="post">
    <div>
        <input type="number" name="numberOne" required>
        <input type="number" name="numberTwo" required>
    </div>
    <div>
        <button name="operator" value="Addition">+</button>
        <button name="operator" value="Subtraction">-</button>
        <button name="operator" value="Multiplication">*</button>
        <button name="operator" value="Division">/</button>
    </div>
</form>
<p>Kết quả là : ${finalResult}</p>
</body>
</html>
