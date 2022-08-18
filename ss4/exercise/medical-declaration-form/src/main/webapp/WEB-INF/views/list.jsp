<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="mt-5 row">
        <div class="col-lg-6">
            <h4>Danh sách tờ khai y tế</h4>
        </div>
        <div class="d-flex justify-content-end col-lg-6">
            <a href="/add">
                <button class="btn btn-success">Thêm mới tờ khai y tế</button>
            </a>
        </div>
    </div>
    <div class="mt-5">
        <table class="table table-hover text-center">
            <tr>
                <th>STT</th>
                <th>Họ tên</th>
                <th>Năm sinh</th>
                <th>CMND/Hộ chiếu</th>
                <th>Quốc tịch</th>
                <th></th>
            </tr>
            <c:forEach items="${list}" var="declaration" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${declaration.name}</td>
                    <td>${declaration.birth}</td>
                    <td>${declaration.idCard}</td>
                    <td>${declaration.nationality}</td>
                    <td>
                        <a href="/update/${declaration.id}">
                            <button class="btn btn-success w-100">Cập nhật</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>
