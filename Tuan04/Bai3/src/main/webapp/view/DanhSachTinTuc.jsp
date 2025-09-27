<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 27/09/2025
  Time: 9:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh Sách Tin Tức</h1>
<table>
    <thead>
        <tr>
            <td>Mã TT</td>
            <td>Tiêu đề</td>
            <td>Nội dung</td>
            <td>Danh mục</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="tinTuc" items="${danhSachTinTuc}">
            <tr>
                <td>${tinTuc.maTT}</td>
                <td>${tinTuc.tieuDe}</td>
                <td>${tinTuc.noiDungTT}</td>
                <td>${tinTuc.danhMuc.tenDanhMuc}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
