<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="text-center">
        <h3>TỜ KHAI Y TẾ</h3>
        <h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH BỆNH TRUYỀN NHIỄM</h4>
        <p class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
            sự</p>
    </div>
    <form:form action="/save" method="post" modelAttribute="declaration">
    <div class="mb-3">
        <form:label path="name" class="form-label">Họ tên (Ghi chữ IN HOA) (*)</form:label>
        <form:input type="text" path="name" class="form-control"/>
    </div>

    <div class="row">
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Năm sinh</label>
                <form:select path="birth" items="${listYear}" class="form-select"/>
            </div>
        </div>
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Giới tính</label>
                <form:select path="gender" items="${listGender}" class="form-select"/>
            </div>
        </div>
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Quốc tịch</label>
                <form:select path="nationality" items="${listNation}" class="form-select"/>
            </div>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label">Số hộ chiếu hoặc CMND hoặc giấy tờ thông hành khác</label>
        <form:input type="text" path="idCard" class="form-control" placeholder="VD: 201757575"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Thông tin đi lại (*)</label>
        <form:radiobuttons path="vehicles" items="${listVehicles}" class="form-check-input"/>
    </div>

    <div class="row">
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Số hiệu phương tiện</label>
                <form:input type="text" path="licensePlates" class="form-control"/>
            </div>
        </div>
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Số ghế</label>
                <form:input type="text" path="seats" class="form-control"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-2">
            <label class="form-label">Ngày khởi hành</label>
            <form:select path="startDay" items="${listDay}" class="form-select"/>
        </div>
        <div class="col-lg-2">
            <label class="form-label">.</label>
            <form:select path="startMonth" items="${listMonth}" class="form-select"/>
        </div>
        <div class="col-lg-2">
            <label class="form-label">.</label>
            <form:select path="startYear" items="${listYear}" class="form-select"/>
        </div>

        <div class="col-lg-2">
            <label class="form-label">Ngày kết thúc</label>
            <form:select path="endDay" items="${listDay}" class="form-select"/>
        </div>
        <div class="col-lg-2">
            <label class="form-label">.</label>
            <form:select path="endMonth" items="${listMonth}" class="form-select"/>
        </div>
        <div class="col-lg-2">
            <label class="form-label">.</label>
            <form:select path="endYear" items="${listYear}" class="form-select"/>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label">Trong vòng 14 ngày qua, Anh/chị có đến tỉnh/thành phố nào? (*)</label>
        <form:textarea path="information" class="form-control"/>
    </div>

    <div class="text-center p-2">
        <button type="submit" class="btn btn-success">Gửi tờ khai</button>
    </div>
</div>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>