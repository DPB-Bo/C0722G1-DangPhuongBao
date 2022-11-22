<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 22/11/2022
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous">

    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <h1 class="text-center">DISPLAY MAILFORM</h1>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Language</th>
            <th>Page Size</th>
            <th>Detail</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${mailFormList}" varStatus="status">
            <tr>
                <th>${status.count}</th>
                <th>${item.languageName}</th>
                <th>${item.pageSize}</th>
                <th>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#showDetail">
                        Detail
                    </button>
                </th>
                <th>
                    <a class="btn btn-success" href="/update?id=${item.id}">
                        Update
                    </a>
                </th>
                <th>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteAlert">
                        Delete
                    </button>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
