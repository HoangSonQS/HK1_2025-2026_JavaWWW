<%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 07/09/2025
  Time: 11:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Tài Khoản</title>
    <style>
        body {
            font-family: Tahoma, Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            padding: 25px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #525D76;
            border-bottom: 2px solid #525D76;
            padding-bottom: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #525D76;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Danh Sách Tài Khoản Đã Đăng Ký</h1>
    <table>
        <thead>
        <tr>
            <th>Họ và Tên</th>
            <th>Email</th>
            <th>Giới Tính</th>
            <th>Ngày Sinh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.gender}</td>
                <td>${user.birthdate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
