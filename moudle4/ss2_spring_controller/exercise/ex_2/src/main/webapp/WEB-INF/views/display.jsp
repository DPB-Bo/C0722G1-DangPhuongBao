<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 21/11/2022
  Time: 14:08
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
</head>
<body>
<div class="container">
  <h1>Caculator</h1>
    <form action="/caculate" method="post">
        <div class="d-flex">
            <div class="input-group">
                <span class="input-group-text">Number 1: </span>
                <input type="number" value="${number1}" name="number1" class="form-control">
                <span class="input-group-text">Number 2: </span>
                <input type="number" value="${number2}" name="number2" class="form-control">
            </div>
        </div>
        <br>
        <input type="submit" name="sign" value="Addition(+)" >
        <input type="submit" name="sign" value="Subtraction(-)" >
        <input type="submit" name="sign" value="Multiplication(x)" >
        <input type="submit" name="sign" value="Division(/)" >
    </form>
    <h2>Kết quả: ${result}</h2>
</div>
</body>
</html>
