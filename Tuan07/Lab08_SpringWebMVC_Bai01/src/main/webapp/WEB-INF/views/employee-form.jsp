<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-container { width: 500px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
        h2 { text-align: center; }
        .form-row { margin-bottom: 15px; display: grid; grid-template-columns: 1fr 2fr; align-items: center; }
        .form-row label { font-weight: bold; }
        .form-row input[type="text"], .form-row input[type="email"], .form-row input[type="date"] {
            width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px;
        }
        .btn { padding: 8px 12px; text-decoration: none; border-radius: 4px; color: white; border: none; cursor: pointer; }
        .btn-primary { background-color: #0d6efd; }
        .btn-secondary { background-color: #6c757d; }
        .button-group { text-align: center; margin-top: 20px; }
    </style>
</head>
<body>
<div class="form-container">
    <h2>REGISTRATION EMPLOYEE</h2>

    <form:form action="${pageContext.request.contextPath}/employees/save"
               modelAttribute="employee" method="POST">

        <form:hidden path="id" />

        <div class="form-row">
            <label for="firstName">First Name</label>
            <form:input path="firstName" id="firstName" placeholder="First Name"/>
        </div>
        <div class="form-row">
            <label for="lastName">Last Name</label>
            <form:input path="lastName" id="lastName" placeholder="Last Name"/>
        </div>
        <div class="form-row">
            <label for="email">Email</label>
            <form:input path="email" id="email" type="email" placeholder="Email"/>
        </div>
        <div class="form-row">
            <label for="dateOfBirth">Date of Birth</label>
            <form:input path="dateOfBirth" id="dateOfBirth" type="date"/>
        </div>
        <div class="form-row">
            <label for="phone">Phone number</label>
            <form:input path="phone" id="phone" placeholder="Phone number"/>
        </div>
        <div class="form-row">
            <label>Gender</label>
            <div>
                <form:radiobutton path="gender" id="genderMale" value="true" /> <label for="genderMale">Male</label>
                <form:radiobutton path="gender" id="genderFemale" value="false" /> <label for="genderFemale">Female</label>
            </div>
        </div>
        <div class="form-row">
            <label for="address">Address</label>
            <form:input path="address" id="address" placeholder="Address"/>
        </div>

        <div class="button-group">
            <a href="${pageContext.request.contextPath}/employees/list" class="btn btn-secondary" style="margin-right: 10px;">Back</a>
            <button type="submit" class="btn btn-primary">Register</button>
        </div>

    </form:form>
</div>
</body>
</html>