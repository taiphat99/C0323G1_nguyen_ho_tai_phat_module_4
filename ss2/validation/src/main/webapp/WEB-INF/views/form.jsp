<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dannynguyen
  Date: 19/07/2023
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validation</title>
</head>
<form action="/validation" method="post">
    <body>
    <h1>Validation</h1>
    <table>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" placeholder="Danny, Louis,..."></td>
            <td></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="text" name="email" placeholder="abc@xyz.com"></td>
            <c:if test="${invalidEmailMsg != null}">
                <td><span style="color: red">${invalidEmailMsg}</span></td>
            </c:if>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"></td>
            <td></td>
        </tr>
    </table>
    <p>Chọn tên xe từ danh sách dưới đây.</p>

    <select id="mySelect" onchange="myFunction()">
        <option value="Audi">Audi
        <option value="BMW">BMW
        <option value="Mercedes">Mercedes
        <option value="Volvo">Volvo
    </select>

    <p>Khi bạn chuyển sang một xe mới, một hàm sẽ được kích hoạt để hiển thị giá trị ra ngoài.</p>

    <p id="demo"></p>

    <script>
        function myFunction() {
            var x = document.getElementById("mySelect").value;
            document.getElementById("demo").innerHTML = "Bạn đã chọn xe: " + x;
        }
    </script>
    </body>

</form>
</html>
