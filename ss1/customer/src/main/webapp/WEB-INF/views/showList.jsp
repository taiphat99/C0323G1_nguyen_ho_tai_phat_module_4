<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 18/07/2023
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<h1>Customer List</h1>
<a href="/showAddForm">Add new customer</a>
<p>
<c:if test="${msg != null}">
    <span>${msg}</span>
</c:if>
</p>
<div class="container">
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th></th>
    </tr>
    <c:forEach items="${customerList}" var="customer" varStatus="loop">
    <tr>
        <td>${loop.count}</td>
        <td>${customer.id}</td>
        <td>${customer.name}</td>
        <td>${customer.email}</td>
        <td><button onclick="sendInfoToModal('${customer.id}')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#deleteModal">Delete</button></td>
    </tr>
    </c:forEach>
</table>
</div>

<div class="modal" tabindex="-1" id="deleteModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Notification</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Are you sure to delete ID <b id="deleteId"></b>?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitDeleteForm()">Delete</button>
            </div>
        </div>
    </div>
</div>
<form id="deleteForm" action="/deleteCustomer" method="post">
    <input type="hidden" name="id" id="addingId">
    <input type="hidden" name="name" id="addingName">
    <input type="hidden" name="email" id="addingEmail">
</form>

<script>
    function sendInfoToModal(id,name){
    document.getElementById("addingId").value = id;
    document.getElementById("deleteId").innerText = id;
    }
    function submitDeleteForm(){
        document.getElementById("deleteForm").submit();
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
