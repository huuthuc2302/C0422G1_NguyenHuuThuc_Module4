<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
            integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
            crossorigin="anonymous"></script>
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
    <form:form action="/create" method="post" modelAttribute="declaration">
    <div class="mb-3">
        <form:label path="name" class="form-label">Họ tên (Ghi chữ IN HOA) (*)</form:label>
        <form:input type="text" path="name" class="form-control"/>
    </div>
    
    <tr>
        <td colspan="2">Năm sinh</td>
        <td colspan="2">Giới tính</td>
        <td colspan="2">Quốc tịch</td>
    </tr>
    <tr>
        <td colspan="2">
            <form:select path="birth" items="${listYear}"/>
        </td>
        <td colspan="2">
            <form:select path="gender" items="${listGender}"/>
        </td>
        <td colspan="2">
            <form:select path="nationality" items="${listNation}"/>
        </td>
    </tr>
    <tr>
        <td colspan="6">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác (*)</td>
    </tr>
    <tr>
        <td colspan="6">
            <form:input type="text" path="idCard"/>
        </td>
    </tr>
    <tr>
        <td colspan="6">Thông tin đi lại (*)</td>
    </tr>
    <tr>
        <td colspan="4">
            <form:radiobuttons path="vehicles" items="${listVehicles}"/>
        </td>
    </tr>
    <tr>
        <td colspan="3">Số hiệu phương tiện</td>
        <td colspan="3">Số ghế</td>
    </tr>
    <tr>
        <td colspan="3">
            <form:input type="text" path="licensePlates"/>
        </td>
        <td colspan="3">
            <form:input type="text" path="seats"/>
        </td>
    </tr>
    <tr>
        <td colspan="3">Ngày khởi hành</td>
        <td colspan="3">Ngày kết thúc</td>
    </tr>
    <tr>
        <td>
            <form:select path="startDay" items="${listDay}"/>
        </td>
        <td>
            <form:select path="startMonth" items="${listMonth}"/>
        </td>
        <td>
            <form:select path="startYear" items="${listYear}"/>
        </td>
        <td>
            <form:select path="endDay" items="${listDay}"/>
        </td>
        <td>
            <form:select path="endMonth" items="${listMonth}"/>
        </td>
        <td>
            <form:select path="endYear" items="${listYear}"/>
        </td>
    </tr>
    <tr>
        <td colspan="6">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố? (*)</td>
    </tr>
    <tr>
        <td colspan="6">
            <form:textarea path="information"/>
        </td>
    </tr>
    <button type="submit">Gửi tờ khai</button>
</div>
</form:form>
</body>
</html>