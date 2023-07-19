<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 19/07/2023
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <form action="/calculate" method="post">
        <div>
            <h1>Calculator</h1>
        </div>
        <div>
            <input type="number" width="100px" placeholder="Param 1" name="firstParam" value="${param1}">
            <input type="number" width="100px" placeholder="Param 2" name="secondParam" value="${param2}">
            <input type="number" width="60px" placeholder="Result" value="${result}" readonly >
        </div>
        <div class="mt-3 ">
            <button name="operation" value="+" type="submit">Addition (+)</button>
            <button name="operation" value="-" type="submit">Subtraction (-)</button>
            <button name="operation" value="*" type="submit">Multiplication (*)</button>
            <button name="operation" value="/" type="submit">Division (/)</button>
        </div>
        <div>
            <c:if test="${msg!= null}">
                <p style="color: crimson">${msg}</p>
            </c:if>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
