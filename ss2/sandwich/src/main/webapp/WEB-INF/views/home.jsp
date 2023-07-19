<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 19/07/2023
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiment Confirmation</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

    <style>
        table, th, tr, td {
            border-collapse: collapse;
            border: black 1px solid;
            padding: 15px;
        }
    </style>
</head>
<body>
<div class="mt-5 container">
    <div>
        <div class="d-flex justify-content-center">
            <h1>Condiment Confirmation</h1>
        </div>
        <div class="d-flex justify-content-center">
            <table>
                <tr>
                    <th>#</th>
                    <th>Condiment</th>
                </tr>
                <c:forEach items="${condiments}" var="condiment" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${condiment}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
