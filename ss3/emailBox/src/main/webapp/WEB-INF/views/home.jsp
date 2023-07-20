<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 20/07/2023
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        table,tr, td {
            padding: 15px;

        }
    </style>
</head>
<body style="margin: 50px 100px">
<h1>Email Box Information</h1>
<form action="/">
    <table>
        <tr>
            <td><b>Language </b></td>
            <td>${emailBox.language}</td>
        </tr>
        <tr>
            <td><b>Emails per Page </b></td>
            <td>${emailBox.pageSize}</td>
        </tr>
        <tr>
            <td><b>Spams Filter </b></td>
            <td>${emailBox.spamFilter}</td>
        </tr>
        <tr>
            <td><b>Signature </b></td>
            <td>${emailBox.signature}</td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Edit</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
