<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 19/07/2023
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="d-flex justify-content-center">
        <h1>Sandwich Condiments</h1>
    </div>
    <div class="mt-3">
        <form action="/submit" method="post">
            <div class="d-flex justify-content-center">
                <label>
                    <input type="checkbox" name="condiments" value="lettuce"> Lettuce
                </label>
                <label class="ms-3">
                    <input type="checkbox" name="condiments" value="tomato"> Tomato
                </label>
                <label class="ms-3">
                    <input type="checkbox" name="condiments" value="mustard"> Mustard
                </label>
                <label class="ms-3">
                    <input type="checkbox" name="condiments" value="sprouts"> Sprouts
                </label>

            </div>

            <div class="d-flex justify-content-center mt-3">
                <button type="submit">Save</button>
            </div>
            <div class="d-flex justify-content-center mt-3 text-danger">
                <c:if test="${msg!= null}">
                    <p>${msg}</p>
                </c:if>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
