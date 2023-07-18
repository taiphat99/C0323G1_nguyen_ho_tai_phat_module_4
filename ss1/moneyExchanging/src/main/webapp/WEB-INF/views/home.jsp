<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 18/07/2023
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Money</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css
">
</head>
<body>
<div class="container">
    <h1>Money Exchange</h1>
    <form action="/exchangeMoney" method="post">
        <div>
            <span>Rate</span>
            <input type="number" value="${rate}" name="rate" placeholder="USD/VND">
        </div>
        <div class="mt-2">
            <span>Amount Money</span>
            <input type="number" value="${amountOfMoney}" name="amountOfMoney" placeholder="USD">
            <button type="submit">Exchange</button>
        </div>
    </form>
</div>
<div class="container">
    <c:if test="${result != null}">
        <h3>Total money: ${result} VND</h3>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
