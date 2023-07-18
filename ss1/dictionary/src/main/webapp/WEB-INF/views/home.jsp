<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 18/07/2023
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css
">
</head>
<body>
<div>
    <form action="/search" method="post">
        <h1>Dictionary</h1>
        <input type="text" name="word" id="word" value="${searchingWord}" required>
        <button type="submit">Search</button>
        <button type="button" onclick="metaSearch()">Meta Search</button>
    </form>
    <c:if test="${result != null}">
        <h2 style="color: crimson">${result}</h2>
    </c:if>
    <form id="metaSearchForm" action="/metaSearch" method="post">
        <input type="hidden" name="word" id="searchingWord">
    </form>
</div>
<script>
    function metaSearch(){
        document.getElementById("searchingWord").value = document.getElementById("word").value ;
        document.getElementById("metaSearchForm").submit();
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
