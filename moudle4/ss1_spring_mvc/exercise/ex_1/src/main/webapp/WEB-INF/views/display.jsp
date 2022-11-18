<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 18/11/2022
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form method="post" action="/display">
  <div class="mb-3">
    <label for="usdValue" class="form-label">USD:</label>
    <input type="number" class="form-control" id="usdValue" name="usdValue" value="${usdValue}">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  <div class="mb-3">
    <label for="result" class="form-label">VND:</label>
    <input type="number" class="form-control" id="result" name="result" value="${result}" readonly>
  </div>
</form>
</div>
</body>
</html>
