<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 03/11/2022
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<h1>DANH SÁCH KHÁCH HÀNH</h1>
<table class="table">

    <tr>
        <th>#</th>
        <th>NAME</th>
        <th>NGÀY SINH</th>
        <th>ĐỊA CHỈ</th>
        <th>ẢNH</th>
    </tr>

    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getBirthDate()}</td>
            <td>${customer.getAddress()}</td>
            <td><img height="250px" src=${customer.getImgLink()}></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
