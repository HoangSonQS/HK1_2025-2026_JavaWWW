<%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 07/09/2025
  Time: 11:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration Form</title>
    <style>
        body { font-family: Tahoma, Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .registration-container { width: 450px; padding: 25px; border: 1px solid #ccc; background-color: #fff; box-shadow: 0 0 10px rgba(0,0,0,0.1); border-radius: 8px; }
        h1 { text-align: center; color: #525D76; border-bottom: 2px solid #525D76; padding-bottom: 10px; margin-bottom: 20px; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; font-weight: bold; margin-bottom: 5px; }
        .form-group input[type="text"],
        .form-group input[type="email"],
        .form-group input[type="password"] { width: calc(100% - 12px); padding: 6px; border: 1px solid #ccc; border-radius: 4px; }
        .form-group .name-fields { display: flex; gap: 10px; }
        .form-group .name-fields input { flex: 1; }
        .form-group .birthday-fields { display: flex; gap: 10px; }
        .form-group .birthday-fields select { flex: 1; padding: 6px; border-radius: 4px; border: 1px solid #ccc; }
        .gender-options input { margin-right: 5px; }
        .btn-signup { width: 100%; padding: 10px; background-color: #525D76; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        .btn-signup:hover { background-color: #4a5468; }
    </style>
</head>
<body>

<div class="registration-container">
    <h1>User Registration Form</h1>
    <form action="registration" method="POST">
        <div class="form-group">
            <label>First Name / Last Name</label>
            <div class="name-fields">
                <input type="text" name="firstName" placeholder="First Name" required>
                <input type="text" name="lastName" placeholder="Last Name" required>
            </div>
        </div>
        <div class="form-group">
            <label>Your Email</label>
            <input type="email" name="email" placeholder="Your Email" required>
        </div>
        <div class="form-group">
            <label>Re-enter Email</label>
            <input type="email" name="reEmail" placeholder="Re-enter Email" required>
        </div>
        <div class="form-group">
            <label>New Password</label>
            <input type="password" name="password" placeholder="New Password" required>
        </div>
        <div class="form-group">
            <label>Birthday</label>
            <div class="birthday-fields">
                <select name="month">
                    <option value="">Month</option>
                    <% for (int i = 1; i <= 12; i++) { %>
                    <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>
                <select name="day">
                    <option value="">Day</option>
                    <% for (int i = 1; i <= 31; i++) { %>
                    <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>
                <select name="year">
                    <option value="">Year</option>
                    <%
                        java.util.Calendar cal = java.util.Calendar.getInstance();
                        int currentYear = cal.get(java.util.Calendar.YEAR);
                        for (int i = currentYear; i >= 1900; i--) {
                    %>
                    <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label>Gender</label>
            <div class="gender-options">
                <input type="radio" name="gender" value="Female"> Female
                <input type="radio" name="gender" value="Male"> Male
            </div>
        </div>
        <button type="submit" class="btn-signup">Sign Up</button>
    </form>
</div>

</body>
</html>
