<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 20/07/2023
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Email Box</title>
</head>
<body style="margin: 50px 100px">
<h1>Setting</h1>
<form:form method="POST" action="update" modelAttribute="emailBox">
    <table>
        <tr>
            <td><b>Language</b></td>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><b>Page size </b></td>
            <td>
                <form:select path="pageSize">
                    Show <form:options items="${pageSizeTypes}"/> emails per page
                </form:select>
            </td>
        </tr>
        <tr>
            <td><b>Spam Filter </b></td>
            <td>
                <form:checkbox path="spamFilter" id="spamFilter"/>
                <form:label for="spamFilter" path="spamFilter">Enable spams filter</form:label>
            </td>
        </tr>
        <tr>
            <td><b>Signature</b></td>
            <td><form:textarea path="signature" cols="30" rows="5"/></td>
        </tr>
        <tr>
            <td>
                <form:button type="submit">Update</form:button>
            </td>
            <td>
                <button>Cancel</button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
