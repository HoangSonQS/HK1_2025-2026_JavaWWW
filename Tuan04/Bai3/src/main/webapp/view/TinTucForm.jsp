<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 27/09/2025
  Time: 10:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm tin tức</title>
</head>
<body>
<h1>Thêm tin tức</h1>
<form action="them" method="post">
    <p>Tiêu đề: <input name="tieuDe" type="text"></p>
    <p>Nội dung: <input name="noiDungTT" type="text"></p>
    <p>Liên kết: <input name="lienKet" type="text"></p>
    <p>Danh mục:
        <select name = "maDM">
            <c:forEach var="danhMuc" items="${danhSachDanhMuc}">
                <option value="${danhMuc.maDM}">${danhMuc.tenDanhMuc}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit">Thêm</button>
</form>
</body>
</html>
