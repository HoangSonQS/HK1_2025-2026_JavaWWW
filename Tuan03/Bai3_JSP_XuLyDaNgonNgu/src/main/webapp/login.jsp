<%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 07/09/2025
  Time: 7:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="login"/></title>
    <style>
        body {
            font-family: Tahoma, Arial, sans-serif;
            background-color: #f0f4f7;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding-top: 50px;
        }

        .form-container {
            background-color: #ffffff;
            border: 1px solid #ccc;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 350px;
        }

        h2 {
            text-align: center;
            color: #525D76;
            margin-top: 0;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        .form-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }

        .form-row label {
            flex: 1;
            margin-right: 10px;
        }

        .form-row input[type="text"], .form-row input[type="password"] {
            flex: 2;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 10px;
            border: none;
            background-color: #525D76;
            color: white;
            cursor: pointer;
            border-radius: 4px;
            font-size: 16px;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: #4a5468;
        }

        input[type="radio"] {
            margin-right: 5px;
        }
    </style>
</head>
<body>

<div class="form-container">
    <c:set var="languageCode" value="${param.radLanguageCode}"/>
    <c:if test="${empty languageCode}">
        <c:set var="languageCode" value="en"/>
    </c:if>

    <fmt:setLocale value="${languageCode}" scope="session"/>
    <fmt:setBundle basename="resource" scope="session"/>

    <h2><fmt:message key="languageMessage"/></h2>
    <form action="login.jsp" method="POST" style="flex-direction: row; justify-content: center; align-items: center;">
        <input type="radio" name="radLanguageCode" value="vi"
                <c:if test="${languageCode == 'vi'}"> checked</c:if> />
        <fmt:message key="vn"/>
        <input type="radio" name="radLanguageCode" value="en"
                <c:if test="${languageCode == 'en'}"> checked</c:if> />
        <fmt:message key="en"/>
        <input type="submit" name="submit" value="<fmt:message key="chooseButton" />"
               style="width: auto; margin-left: 10px;"/>
    </form>
</div>

<div class="form-container">
    <h2><fmt:message key="login"/></h2>
    <form action="login.jsp" method="POST">
        <div class="form-row">
            <label><fmt:message key="userName"/></label>
            <input type="text" name="txtUserName" value=""/>
        </div>
        <div class="form-row">
            <label><fmt:message key="pass"/></label>
            <input type="password" name="txtPassword" value=""/>
        </div>
        <input type="submit" name="submit" value="<fmt:message key="login" />"/>
    </form>
</div>

</body>
</html>