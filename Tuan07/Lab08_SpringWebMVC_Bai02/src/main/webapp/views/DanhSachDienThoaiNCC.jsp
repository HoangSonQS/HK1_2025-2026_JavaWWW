<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<h1>Danh Sách Điện Thoại</h1>

<head>
    <meta charset="UTF-8">
    <title>Danh Sách Điện Thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            padding-bottom: 60px;
        }

        .header {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header .logo {
            font-size: 24px;
            font-weight: bold;
        }

        .nav a {
            color: white;
            margin: 0 15px;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 4px;
        }

        .nav a:hover {
            background-color: #575757;
        }

        .container {
            padding: 20px;
            max-width: 1200px;
            margin: auto;
        }

        .footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
            z-index: 10;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: white;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        img.product-img {
            width: 50px;
            height: 50px;
            object-fit: cover;
        }

        .header-controls {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }

        .search-bar {
            display: flex;
            gap: 5px;
        }

        .search-bar input[type="text"] {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn {
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 4px;
            color: white;
            border: none;
            cursor: pointer;
            display: inline-block;
        }

        .btn-primary {
            background-color: #0d6efd;
        }

        .btn-secondary {
            background-color: #6c757d;
        }

        .btn-warning {
            background-color: #ffc107;
            color: #000;
        }

        .btn-danger {
            background-color: #dc3545;
        }

        .supplier-list {
            list-style: none;
            padding: 0;
            margin: 0;
            border: 1px solid #ddd;
            border-radius: 4px;
            background-color: #fff;
            max-height: 60vh;
            overflow-y: auto;
        }

        .supplier-item a {
            display: block;
            padding: 10px 15px;
            text-decoration: none;
            color: #333;
            border-bottom: 1px solid #eee;
        }

        .supplier-item a:hover {
            background-color: #f8f9fa;
        }

        .supplier-item a.active {
            font-weight: bold;
            background-color: #e9ecef;
            color: #000;
        }

        .supplier-item:last-child a {
            border-bottom: none;
        }

        .column-container {
            display: flex;
            gap: 20px;
        }

        .supplier-column {
            width: 30%;
            flex-shrink: 0;
        }

        .product-column {
            width: 70%;
            flex-grow: 1;
        }
    </style>
</head>

<div class="header-controls">
    <div class="search-bar">
        <form action="${pageContext.request.contextPath}/dienthoai-jsp/list" method="get">
            <input type="text" name="keywordNcc" value="${keywordNcc}" placeholder="Tìm NCC (Tên, ĐC, SĐT)">
            <button type="submit" class="btn btn-secondary">Tìm NCC</button>
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/dienthoai-jsp/showFormAdd" class="btn btn-primary">
        Thêm Điện Thoại
    </a>
</div>

<div class="column-container">
    <div class="supplier-column">
        <h3>Nhà Cung Cấp</h3>
        <ul class="supplier-list">
            <c:forEach var="ncc" items="${dsNhaCungCap}">
                <li class="supplier-item">
                    <a href="${pageContext.request.contextPath}/dienthoai-jsp/list?maNcc=${ncc.maNCC}"
                       class="${nccHienTai != null && nccHienTai.maNCC == ncc.maNCC ? 'active' : ''}">
                            ${ncc.tenNhaCC}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="product-column">
        <h3 style="margin-top: 0;">
            <c:choose>
                <c:when test="${nccHienTai != null}">
                    Điện Thoại của ${nccHienTai.tenNhaCC}
                </c:when>
                <c:otherwise>
                    Vui lòng chọn Nhà Cung Cấp
                </c:otherwise>
            </c:choose>
        </h3>

        <c:choose>
            <c:when test="${dsDienThoai != null and not empty dsDienThoai}">
                <table>
                    <thead>
                    <tr>
                        <th>Ảnh</th>
                        <th>Tên ĐT</th>
                        <th>Năm SX</th>
                        <th>Cấu hình</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dt" items="${dsDienThoai}">
                        <c:url var="updateLink" value="/dienthoai-jsp/showFormUpdate">
                            <c:param name="id" value="${dt.maDT}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/dienthoai-jsp/delete">
                            <c:param name="id" value="${dt.maDT}" />
                            <c:if test="${nccHienTai != null}">
                                <c:param name="maNcc" value="${nccHienTai.maNCC}" />
                            </c:if>
                        </c:url>
                        <tr>
                            <td>
                                <c:if test="${not empty dt.hinhAnh}">
                                    <img src="${pageContext.request.contextPath}/uploaded-images/${dt.hinhAnh}"
                                         alt="Ảnh SP" class="product-img">
                                </c:if>
                            </td>
                            <td>${dt.tenDT}</td>
                            <td>${dt.namSanXuat}</td>
                            <td>${dt.cauHinh}</td>
                            <td>
                                <a href="${updateLink}" class="btn btn-warning btn-sm">Sửa</a>
                                <a href="${deleteLink}" class="btn btn-danger btn-sm"
                                   onclick="return confirm('Bạn chắc chắn muốn xóa?')">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:when test="${nccHienTai != null and empty dsDienThoai}">
                <p>Không có điện thoại nào cho nhà cung cấp này.</p>
            </c:when>
        </c:choose>
    </div>
</div>

<%@ include file="Footer.jsp" %>