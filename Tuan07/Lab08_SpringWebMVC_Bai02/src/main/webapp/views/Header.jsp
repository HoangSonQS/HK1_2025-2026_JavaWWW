<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Điện Thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            padding-bottom: 60px; /* Thêm padding để footer không che nội dung */
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

        /* Giới hạn chiều rộng container */
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

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input, .form-group select, .form-group textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
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

        .form-container {
            width: 600px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: white;
        }

        .button-group {
            text-align: center;
            margin-top: 20px;
        }

        .form-error {
            color: red;
            font-size: 0.9em;
        }

        .form-row {
            margin-bottom: 15px;
            display: grid;
            grid-template-columns: 150px 1fr;
            align-items: center;
            gap: 10px;
        }

        .form-row label {
            font-weight: bold;
            text-align: right;
        }

        .form-row div {
            text-align: left;
        }

        /* Căn lề trái cho input/select */
    </style>
</head>
<body>
<div class="header">
    <div class="logo">fongo | HomePhone</div>
    <div class="nav">
        <a href="${pageContext.request.contextPath}/dienthoai-jsp/list">Danh sách sản phẩm</a>
        <a href="${pageContext.request.contextPath}/dienthoai-jsp/showFormAdd">Thêm mới sản phẩm</a>
    </div>
</div>
<div class="container">