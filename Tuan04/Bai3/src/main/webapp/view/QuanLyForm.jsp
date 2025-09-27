<%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 27/09/2025
  Time: 10:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Quản lý tin tức</title>
</head>
<body>
<h1>Quản lý tin tức</h1>
<table border="1">
  <thead>
  <tr>
    <th>Mã TT</th>
    <th>Tiêu đề</th>
    <th>Thao tác</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="tinTuc" items="${danhSachTinTuc}">
    <tr>
      <td>${tinTuc.maTT}</td>
      <td>${tinTuc.tieuDe}</td>
      <td>
        <form action="quanly" method="post" style="display:inline;">
          <input type="hidden" name="maTT" value="${tinTuc.maTT}">
          <button type="submit">Xóa</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
