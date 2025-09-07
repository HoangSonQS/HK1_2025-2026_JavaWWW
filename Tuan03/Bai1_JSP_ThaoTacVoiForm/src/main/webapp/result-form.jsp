<%@ page import="iuh.fit.se.bai1_jsp_thaotacvoiform.models.Student" %><%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 07/09/2025
  Time: 10:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result submit</title>
</head>
<body>
<%
    Student student = new Student();
    student = (Student) request.getAttribute("student");
    out.println(
            "First name: " + student.getFirstName()
                    + "<br/> Last name: " + student.getLastName()
                    + "<br/> Email: " + student.getEmail()
                    + "<br/> Gender: " + student.getGender()
                    + "<br/> Birthday: " + student.getBirthdate()
                    + "<br/> Student: " + student.toString()

    );
%>
</body>
</html>
