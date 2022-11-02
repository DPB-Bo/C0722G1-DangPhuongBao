<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/CalculateDiscountServlet">
    <label for="pro_de">Product Description:</label>
    <input type="text" name="pro_des" id="pro_de">
    <br>
    <label for="list_pr">List Price:</label>
    <input type="text" name="list_pr" id="list_pr">
    <br>
    <label for="dis_per">Discount Percent:</label>
    <input type="text" name="dis_per" id="dis_per">
    <br>
    <input type="submit" value="Calculate Discount">
</form>
</body>
</html>