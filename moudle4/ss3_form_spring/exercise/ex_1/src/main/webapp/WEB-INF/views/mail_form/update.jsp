<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 22/11/2022
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h1>Settings Update</h1>
    <form:form method="post" action="/update123" modelAttribute="mailForm">
        <form:hidden path="id"></form:hidden>
        <form:label path="languageName">Languages: </form:label>
        <form:select path="languageName" items="${languageNameList}"></form:select> <br>
        <form:label path="pageSize">Page Size: </form:label>
        <form:select path="pageSize" items="${pageSizeList}"></form:select> <br>
        <form:label path="filter">Spams Filters: </form:label>
        <form:checkbox path="filter" value="true"></form:checkbox> <br>
        <form:label path="description">Signature: </form:label>
        <form:textarea path="description"></form:textarea> <br>
        <input type="submit" value="Lưu">
    </form:form>
</div>
</body>
</html>
