<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <style>
        body {
            font-family: Arial,
            sans-serif;
            margin: 20px;
        }

        .container {
            width: 90%;
            margin: auto;
        }

        h2 {
            text-align: center;
        }

        .btn {
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 4px;
            color: white;
            border: none;
            cursor: pointer;
        }

        .btn-primary {
            background-color: #0d6efd;
        }

        .btn-secondary {
            background-color: #6c757d;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .header-controls {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            margin-bottom: 15px;
        }

        .search-bar {
            display: flex;
            gap: 5px;
            margin-right: 10px;
        }

        .search-bar input[type="text"] {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 300px;
        }

        .search-bar input[type="submit"] {
            padding: 8px 12px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>EMPLOYEE LIST</h2>

    <div class="header-controls">

        <div class="search-bar">
            <form action="${pageContext.request.contextPath}/employees/list" method="GET">
                <input type="text" name="keyword" value="${keyword}"
                       placeholder="Search by Name, Email, Phone, Address...">
                <input type="submit" value="Search" class="btn btn-secondary">
            </form>
        </div>

        <a href="${pageContext.request.contextPath}/employees/showFormForAdd" class="btn btn-primary">
            Add Employee
        </a>
    </div>

    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Date of birth</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tempEmployee" items="${employees}">

            <c:url var="updateLink" value="/employees/showFormForUpdate">
                <c:param name="employeeId" value="${tempEmployee.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/employees/delete">
                <c:param name="employeeId" value="${tempEmployee.id}"/>
            </c:url>

            <tr>
                <td>${tempEmployee.firstName}</td>
                <td>${tempEmployee.lastName}</td>
                <td>${tempEmployee.gender ? 'Male' : 'Female'}</td>
                <td>${tempEmployee.dateOfBirth}</td>
                <td>${tempEmployee.email}</td>
                <td>${tempEmployee.phone}</td>
                <td>
                    <a href="${updateLink}">Update</a> |
                    <a href="${deleteLink}"
                       onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>