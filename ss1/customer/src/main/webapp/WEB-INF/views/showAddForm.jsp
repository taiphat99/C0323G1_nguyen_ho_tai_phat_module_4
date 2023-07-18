<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 18/07/2023
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Form</title>
</head>
<body>
<h1>Add New Customer</h1>
<form action="/addNewCustomer" method="post">
<table>
    <tr>
        <td>ID:</td>
        <td>Name:</td>
        <td>Email:</td>
        <td></td>
    </tr>
    <tr>
        <td><input type="number" name="id" required></td>
        <td><input type="text" name="name" required></td>
        <td><input type="email" name="email" required></td>
        <td><button type="submit">Done</button></td>
    </tr>
</table>
</form>
</body>
</html>
