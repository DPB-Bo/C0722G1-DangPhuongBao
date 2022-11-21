<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 21/11/2022
  Time: 11:01
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
</head>
<body>
<div class="container">
    <h2> Sandwich Condiments</h2>
    <form method="post" action="/showSeasonings">
        <div class="d-flex">

            <div class="input-group-text">
                <input class="form-check-input mt-0" name="checkSeasonings" type="checkbox" value="Lettuce"
                       aria-label="Checkbox for following text input">
                Lettuce
            </div>

            <div class="input-group-text">
                <input class="form-check-input mt-0" name="checkSeasonings" type="checkbox" value="Tomato"
                       aria-label="Checkbox for following text input">
                Tomato
            </div>

            <div class="input-group-text">
                <input class="form-check-input mt-0" name="checkSeasonings" type="checkbox" value="Mustard"
                       aria-label="Checkbox for following text input">
                Mustard
            </div>

            <div class="input-group-text">
                <input class="form-check-input mt-0" name="checkSeasonings" type="checkbox" value="Sprouts"
                       aria-label="Checkbox for following text input">
                Sprouts
            </div>

        </div>
        <hr>
        <input class="btn btn-success" type="submit" value="Save">
    </form>

    <p>Danh sách gia vị chọn</p>
    <c:if test="${listSeasonings != null}">
        <c:forEach var="seasoning" items="${listSeasonings}">
            <p>${seasoning}</p>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
